package gz.itcast.a_gui;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * �ع�GUI���¼����
 * @heyutong
 * 2017��5��25��
 */
public class Demo1 {
	public static void main(String[] args) {
		//1������һ������
		Frame f = new Frame("����һ���µĴ���");
		//2)���ô�С
		f.setSize(300, 300);
		//3)���ÿɼ���
		f.setVisible(true);
		//4)�Ѽ�����ע�ᵽ�¼�Դ��
		f.addWindowListener(new MyWindowListener());
	}
}

/**
 * ���ڵ��¼�������
 * @heyutong
 * 2017��5��25��
 */
class MyWindowListener implements WindowListener {

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {//WindowEvent�����¼����󣬰������¼�Դ����
		//���¼�����õ��¼�Դ����
		Frame f =  (Frame)e.getSource();
		//1)������ʧ
		f.setVisible(false);
		//2)����ֹͣ
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


