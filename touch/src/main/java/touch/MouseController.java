package touch;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
//		System.load("C:/Users/itachi/Documents/Visual Studio 2010/Projects/tdll/tdll/x64/Debug/tdll.dll");
		MouseController c = new MouseController();
//		c.clickLeft();
//		c.clickRight();
		
//		c.scroll(-1);
		c.back();
		c.go();
		
	}
	// c++ 实现 
//	public native void clickLeft();
	
//	public native void clickRight();
	
//	public native void dbClick();
	
//	public native void move(int x, int y)
	
//	public native void scroll(int x)
	
	
	// java 实现
	public void clickLeft() {
		// 不兼容
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	}
	
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
	
	public void scroll(int y) {
		robot.mouseWheel(y);
		System.out.println("滚动：" + y);
	}


	public void go() {
		System.out.println("前进");
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_ALT);
	}


	public void back() {
		System.out.println("后退");
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_ALT);
	}
}
