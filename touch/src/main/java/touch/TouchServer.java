package touch;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * App版服务器
 *
 */
public class TouchServer {

	ServerSocket ss;
	
	public static void main(String[] args) throws Exception {
		TouchServer server = new TouchServer();
		server.start();
	}
	
	public TouchServer() throws IOException {
		ss = new ServerSocket(5230);
		System.out.println("touch server was started!");
	}
	
	public void start() {
		while (true) {
			try {
				process(ss.accept());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void process(Socket socket) {
		try {
			new SocketWindowsProcessor(socket).start();
		} catch (Exception e) {
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		ss.close();
	}
	
	
	
}

/**
 * 
 * 消息处理器
 *
 */
class SocketWindowsProcessor extends Thread {
	
	Socket socket;
	
	static Map<String, Action> map;
	static MouseController controller;
	
	{
		map = new HashMap<String, Action>();
		controller = new MouseController();
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
				int x = (int) message.x * -1;
				int y = (int) message.y * -1;
				controller.move(x, y);
			}
		});
		map.put("scroll", new Action(){
			public void execute(WindowsMessage message) {
				
			}
		});
	}
	
	public SocketWindowsProcessor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			byte[] buf = new byte[64];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				WindowsMessage message = WindowsMessage.parse(new String(buf, 0, len));
				System.out.println(message);
				Action action = map.get(message.action);
				if (action != null) {
					action.execute(message);
				}
			}
		} catch (Exception e) {
		}
	}
}

