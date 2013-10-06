package touch;

public class WindowsMessage {
	
	String action;
	float x, y, x1, y1, x2, y2;

	public WindowsMessage(String action) {
		this.action = action;
	}

	public WindowsMessage(String action, float x, float y) {
		super();
		this.action = action;
		this.x = x;
		this.y = y;
	}
	
	public WindowsMessage(String action, float x, float y, float x1, float y1,
			float x2, float y2) {
		super();
		this.action = action;
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return action + "," + x + "," + y + "," + x1 + "," + y1 + "," + x2
				+ "," + y2;
	}

	public static WindowsMessage parse(String str) {
		String[] params = str.split(",");
		String action = params[0];
		float x = Float.valueOf(params[1]);
		float y = Float.valueOf(params[2]);
		float x1 = Float.valueOf(params[3]);
		float y1 = Float.valueOf(params[4]);
		float x2 = Float.valueOf(params[5]);
		float y2 = Float.valueOf(params[6]);
		return new WindowsMessage(action, x, y, x1, y1, x2, y2);
	}
}
