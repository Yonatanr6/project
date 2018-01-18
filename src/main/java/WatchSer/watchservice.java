package WatchSer;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import DB.MySql;
import Tools.Writer;
import gui_.gui;

//https://gist.github.com/taichi/2508403
//https://www.youtube.com/watch?v=fcNp2SsWOeM for the watchservice

public class watchservice implements Runnable {

	
	static void reg(Path dir, Map<WatchKey, Path> KeyMap, WatchService ws)
			throws IOException {
		WatchKey key = dir.register(ws, ENTRY_CREATE, ENTRY_DELETE,
				ENTRY_MODIFY);
		KeyMap.put(key, dir);
	}

	@SuppressWarnings("unchecked")
	static <T> WatchEvent<T> cast(WatchEvent<?> event) {
		return (WatchEvent<T>) event;
	}

	@Override
	public void run() {
		
		try (WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> KeyMap = new HashMap<>();
			Path path = Paths.get("Data\\input");
			KeyMap.put(path.register(service,
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY
					),path);
			WatchKey watchKey;
			reg(Paths.get("Data/input/comb"), KeyMap, service);
			reg(Paths.get("Data/input/no_gps"), KeyMap, service);
			reg(Paths.get("Data/input/WigleWifi"), KeyMap, service);
			

			do {
				if(gui.countClick!=0&&MySql.CheckIfUpToDate()){
				System.out.println("SQL updated");
				MySql.getTableUpdate(gui.data);
			}
				
				watchKey = service.take();
				Path eventDir = KeyMap.get(watchKey);
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(eventDir + ":" + kind + ":"+eventPath);
					gui.data.add_wigle("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\input\\WigleWifi");
					gui.data.comb_adder("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\input\\comb");
					Writer write =new Writer(gui.data);
				}
			} while(watchKey.reset());
			
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}