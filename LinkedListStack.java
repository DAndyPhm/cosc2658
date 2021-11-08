// LinkedList implementation of stack
public class LinkedListStack<T> {
  // this class is used as a container to data 
  static class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  private int size;
  private Node<T> head;

  public LinkedListStack() {
    size = 0;
    head = null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean push(T item) {
    Node<T> n = new Node<T>(item);
    if (!isEmpty()) {
      n.next = head;
    }
    head = n;
    size++;
    return true;
  }

  public boolean pop() {
    // make sure the stack is not empty
    if (isEmpty()) {
      return false;
    }
    // advance head
    head = head.next;
    size--;
    return true;
  }

  public T peek() {
    // make sure the stack is not empty
    if (isEmpty()) {
      return null;
    }
    return head.data;
  }

  public static void main(String[] args) {
    LinkedListStack<String> list = new LinkedListStack<String>();
    list.push("hello");
    list.push("world");
    System.out.println(list.peek());
    list.pop();
    list.push("from RMIT");
    System.out.println(list.peek());
    list.pop();
    System.out.println(list.peek());
    list.pop();
    System.out.println(list.peek());
    list.pop();
  }
}
