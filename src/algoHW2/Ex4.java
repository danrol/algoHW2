package algoHW2;

import java.util.Stack;

public class Ex4 {

	 Stack<Integer> s1 = new Stack<Integer>();
	 Stack<Integer> s2 = new Stack<Integer>();

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public void enqueue(int num){
		s1.push(num);
	}
	
	public int dequeue() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public static void main(String[] args) throws Exception {
		
    }
}
