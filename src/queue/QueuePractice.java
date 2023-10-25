package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {

	public static void main(String[] args) {
//		Queue<Integer> q = new PriorityQueue<>();
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.add(4);
//		
//		System.out.println(q);
//		System.out.println(q.remove()+" "+q.remove());
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		Iterator<Integer> iterator = ll.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
			
		}
		
		
		
		System.out.println(ll);
	}

}
