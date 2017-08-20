package datastructure.queue;

import java.util.Stack;
/**
 * ������ջģ�����(��Stackʵ��)
 * ջA(����ջ) ջB(����ջ) ʵ�ֶ���Q
 * 1.����У���ջA����
 * 2.������
 * (1)ջB��Ϊ�գ�����B������
 * (2)ջBΪ��:����A�����ݡ�����ջB�С��ٵ���ջB������
 * @param <E>
 */
public class MyQueue<E> {
	private Stack<E> s1 = new Stack<E>();
	private Stack<E> s2 = new Stack<E>();
	
	//�����:A��ջ
	public synchronized void put(E e) {
		s1.push(e);
	}
	
	//������
	public synchronized E pop() {
		if(s2.isEmpty()) {
			while (!s1.isEmpty()) {
				E pop = s1.pop();
				s2.push(pop);
			}
		}
		
		return s2.pop();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.put(1);
		q.put(2);
		System.out.println("������Ԫ��:" + q.pop());
		System.out.println("������Ԫ��:" + q.pop());
	}
}
