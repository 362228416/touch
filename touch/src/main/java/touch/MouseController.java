package touch;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseController {
	private Robot robot;

	public MouseController() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		MouseController c = new MouseController();
		c.clickLeft();
		c.clickRight();
	}
	
	public void clickLeft() {
		// 不兼容
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	}
	
	// c++ 实现 
//	public native void clickLeft();
	
//	public native void clickRight();
	
	
	public void clickRight() {
		// 不兼容
//		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
	}
	
	public void dbClick() {
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void move(int x, int y) {
		Point point = MouseInfo.getPointerInfo().getLocation();
		x += point.getX();
		y += point.getY();
		robot.mouseMove(x, y);
	}
	
	public void scroll(int x) {
		robot.mouseWheel(x);
	}
}
