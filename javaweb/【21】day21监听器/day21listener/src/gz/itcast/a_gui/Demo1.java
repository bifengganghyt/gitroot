package gz.itcast.a_gui;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 回顾GUI的事件编程
 * @heyutong
 * 2017年5月25日
 */
public class Demo1 {
	public static void main(String[] args) {
		//1）创建一个窗体
		Frame f = new Frame("这是一个新的窗体");
		//2)设置大小
		f.setSize(300, 300);
		//3)设置可见性
		f.setVisible(true);
		//4)把监听器注册到事件源上
		f.addWindowListener(new MyWindowListener());
	}
}

/**
 * 窗口的事件监听器
 * @heyutong
 * 2017年5月25日
 */
class MyWindowListener implements WindowListener {

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {//WindowEvent就是事件对象，包含了事件源对象
		//从事件对象得到事件源对象
		Frame f =  (Frame)e.getSource();
		//1)窗体消失
		f.setVisible(false);
		//2)程序停止
		System.exit(-1);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
		
	}

	public void windowDeiconified(WindowEvent e) {
		
	}

	public void windowActivated(WindowEvent e) {
		
	}

	public void windowDeactivated(WindowEvent e) {
	}
	
	
}


