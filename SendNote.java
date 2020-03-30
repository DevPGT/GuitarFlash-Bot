package Main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class SendNote extends Thread {

	public SendNote(int key) throws AWTException {
		// TODO Auto-generated constructor stub
		this.key = key;
		
	}
	int key = 0;
	Robot robot = new Robot();
	@Override
    public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(key)
		{
		case 0:
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			break;
		case 1:
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			break;
		case 2:
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_J);
			break;
		case 3:
			robot.keyPress(KeyEvent.VK_K);
			robot.keyRelease(KeyEvent.VK_K);
			break;
		case 4:
			robot.keyPress(KeyEvent.VK_L);
			robot.keyRelease(KeyEvent.VK_L);
			break;
		}

	}
}
