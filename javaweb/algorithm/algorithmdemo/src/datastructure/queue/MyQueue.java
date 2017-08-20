package datastructure.queue;

import java.util.Stack;
/**
 * 用两个栈模拟队列(用Stack实现)
 * 栈A(插入栈) 栈B(弹出栈) 实现队列Q
 * 1.入队列：入栈A即可
 * 2.出队列
 * (1)栈B不为空，弹出B的数据
 * (2)栈B为空:弹出A的数据—放入栈B中—再弹出栈B的数据
 * @param <E>
 */
public class MyQueue<E> {
	private Stack<E> s1 = new Stack<E>();
	private Stack<E> s2 = new Stack<E>();
	
	//入队列:A入栈
	public synchronized void put(E e) {
		s1.push(e);
	}
	
	//出队列
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
		System.out.println("队列首元素:" + q.pop());
		System.out.println("队列首元素:" + q.pop());
	}
}
