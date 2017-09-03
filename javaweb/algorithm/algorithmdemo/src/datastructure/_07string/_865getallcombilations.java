package datastructure._07string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _865getallcombilations {
	private int[] numbers = {1,2,2,3,4,5};
	private int n = numbers.length;
	//�������ͼ�н�ϵ��Ƿ񱻱�����
	private boolean[] visited = new boolean[n];
	//ͼ�Ķ�ά�����ʾ
	private int[][] graph =  new int[n][n];
	//���ֵ����
	private String combination = " ";
	
	public Set<String> getAllCombination() {
		//����ͼ
		buildGraph();
		//�������������� :��֤���ݲ��ظ�
		HashSet<String> set = new HashSet<String>();
		//�ֱ�Ӳ�ͬ�ڵ㴦����ȱ���ͼ
		for(int i=0;i<n;i++) {
			this.depthFirstSearch(i, set);
		}
		
		return set;
	}
	
	private void buildGraph() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					graph[i][j]=0;
				} else {
					graph[i][j]=1;
				}
			}
			graph[3][5]=0;
			graph[5][3]=0;
		}
	}
	
	private void depthFirstSearch(int start,Set<String> set) {
		visited[start] = true;
		combination = combination+numbers[start];
		if(combination.length()==n) {
			//4�������ڵ�����λ��
			if(combination.indexOf("4") != 2) {
				set.add(combination);
			}
		}
		
		for(int j=0;j<n;j++) {
			if(graph[start][j]==1&&visited[j]==false) {
				depthFirstSearch(j, set);
			}
		}
		
		combination=combination.substring(0, combination.length()-1);
		visited[start] =false;
	}
	
	public static void main(String[] args) {
		_865getallcombilations t = new _865getallcombilations();
		Set<String> set = t.getAllCombination();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String num = iterator.next();
			System.out.println(num);
		}
	}
}
