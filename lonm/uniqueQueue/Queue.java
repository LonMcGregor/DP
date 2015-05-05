package lonm.uniqueQueue;


public interface Queue<E> {
	  public int size();
	  public boolean isEmpty();
	  public E front() throws ArrayListQueueException;
	  public void enqueue(E element);
	  public E dequeue()  throws ArrayListQueueException;
	  public String toString();
	}
