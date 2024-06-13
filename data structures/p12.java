import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque {
    private Node head, tail;
    private int size;

    private static class Node {
        Object item;
        Node next, prev;
        Node(Object item) { this.item = item; }
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public void addFirst(Object item) {
        Node newNode = new Node(item);
        if (isEmpty()) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object item) {
        Node newNode = new Node(item);
        if (isEmpty()) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Object removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Object item = head.item;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return item;
    }

    public Object removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Object item = tail.item;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return item;
    }

    public Object peekFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.item;
    }

    public Object peekLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.item;
    }

    public static void main(String[] args) {
        Deque deque = new Deque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command: addFirst, addLast, removeFirst, removeLast, peekFirst, peekLast, exit");
            String command = scanner.nextLine();

            if (command.equals("exit")) break;

            switch (command) {
                case "addFirst":
                    System.out.println("Enter item:");
                    deque.addFirst(scanner.nextLine());
                    break;
                case "addLast":
                    System.out.println("Enter item:");
                    deque.addLast(scanner.nextLine());
                    break;
                case "removeFirst":
                    try {
                        System.out.println("Removed: " + deque.removeFirst());
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty");
                    }
                    break;
                case "removeLast":
                    try {
                        System.out.println("Removed: " + deque.removeLast());
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty");
                    }
                    break;
                case "peekFirst":
                    try {
                        System.out.println("First: " + deque.peekFirst());
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty");
                    }
                    break;
                case "peekLast":
                    try {
                        System.out.println("Last: " + deque.peekLast());
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty");
                    }
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}
