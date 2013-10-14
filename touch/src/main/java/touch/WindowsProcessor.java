package touch;

import java.util.HashMap;
import java.util.Map;

public class WindowsProcessor {

	private static final Map<String, Action> map =  new HashMap<String, Action>();
	private static final MouseController controller = new MouseController();
	
	static {
//		System.out.println("init handle.");
		map.put("clickLeft", new Action(){
			public void execute(WindowsMessage message) {
				controller.clickLeft();
			}
		});
		map.put("clickRight", new Action(){
			public void execute(WindowsMessage message) {
				controller.clickRight();
			}
		});
		map.put("dbClick", new Action(){
			public void execute(WindowsMessage message) {
				controller.dbClick();
			}
		});
		map.put("move", new Action(){
			public void execute(WindowsMessage message) {
				int x = (int) message.x;
				int y = (int) message.y;
				controller.move(x, y);
			}
		});
		map.put("scroll", new Action(){
			public void execute(WindowsMessage message) {
				controller.scroll((int) message.y);
			}
		});
		map.put("go", new Action(){
			public void execute(WindowsMessage message) {
				controller.go();
			}
		});
		map.put("back", new Action(){
			public void execute(WindowsMessage message) {
				controller.back();
			}
		});
		
	}
	
	public static void process(WindowsMessage message) {
//		System.out.println(message);
		Action action = map.get(message.action);
		if (action != null) {
			action.execute(message);
		}
	}
	
}
