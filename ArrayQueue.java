// Array implementation of queue
public class ArrayQueue<T> {
  private int size;
  private static int MAX_SIZE = 100;
  private T[] items;

  public ArrayQueue() {
    size = 0;
    items = (T[])new Object[MAX_SIZE];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean enQueue(T item) {
    // make sure the queue still have empty slot
    if (size < MAX_SIZE) {
      items[size] = item;
      size++;
      return true;
    }
    return false;
  }

  public boolean deQueue() {
    // make sure the queue is not empty
    if (isEmpty()) {
      return false;
    }
    // shift left
    for (int i = 0; i < size - 1; i++) {
      items[i] = items[i + 1];
    }
    size--;
    items[size] = null;  // is this assignment necessary?
    return true;
  }

  public T peekFront() {
    // make sure the queue is not empty
    if (isEmpty()) {
      return null;
    }
    return items[0];
  }

  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
    queue.enQueue(20);
    queue.enQueue(33);
    System.out.println(queue.peekFront());
    queue.deQueue();
    queue.enQueue(7);
    System.out.println(queue.peekFront());
    queue.deQueue();
    System.out.println(queue.peekFront());
    queue.deQueue();
    System.out.println(queue.peekFront());
    queue.deQueue();
  }
}
