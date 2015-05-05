package lonm.uniqueQueue;

import java.util.ArrayList;

public class UniqueQueue<E> implements Queue<E> {

	private int f; // front of queue
	private int r; // rear of queue
    private ArrayList<E> Q;
    
    //create a queue
    @SuppressWarnings("unchecked")
	public UniqueQueue(){
        Q = (ArrayList<E>) new ArrayList<Object>();
        r = 0;
        f = 0;
    }
	
    //how big is the arraylist
	public int size() {
		return Q.size();
	}

	//is the arraylist empty
	public boolean isEmpty() {
			return Q.isEmpty();
	}

	//returns the item at front of queue
	public E front() throws ArrayListQueueException {
		return Q.get(f);
	}

	//adds item to queue
	public void enqueue(E element) {
		if (!Q.contains(element)){
			Q.add(r, element);
			r++;
		}
	}

	//returns and removes first item in queue
	@SuppressWarnings("unchecked")
	public E dequeue() throws ArrayListQueueException {
		if(isEmpty()){
			throw new ArrayListQueueException("It's empty!");
		} else {
			Object o = Q.get(f);
			f++;
			return (E) o; 
		}		
	}


    //returns the queue as a string
    public String toString(){
    	String a;
    	a = "[";
    	for (Object e : Q){
    		a = a + " " + e.toString() + ",";
    	}
    	a = a + "]";
    	return a;
    }
}
