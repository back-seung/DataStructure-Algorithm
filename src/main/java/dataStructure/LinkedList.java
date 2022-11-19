package dataStructure;import java.util.List;/* * Boundary Conditions *   1. 비어있는 자료구조 *   2. 자료구조에 단 하나의 요소가 들어있을 때 *   3. 자료구조의 시작 요소를 추가/삭제 *   4. 자료구조의 마지막 요소를 추가/삭제 *   5. 자료구조의 중간 부분을 처리할 때 * */public class LinkedList<E> { // implements List<E>    class Node<E> {        E data;        Node<E> next;        public Node(E obj) {            this.data = obj;            next = null;        }    }    private Node<E> head;    private Node<E> tail;    private int currentSize;    public LinkedList() {        head = null;        tail = null;        currentSize = 0;    }    public void addFirst(E obj) {        Node<E> node = new Node<E>(obj);        node.next = head;        head = node;        currentSize++;    }    public void addLast(E obj) {        Node<E> node = new Node<E>(obj);        if (head == null) {            head = node;            currentSize++;            return;         }        tail.next = node;        tail = node;        currentSize++;        return;    }    public E removeFirst(E obj) {        if (head == null) {            return null;        }        E temp = head.data;        if (head == tail) {            head = null;            tail = null;        } else {            head = head.next;            currentSize--;        }        return temp;    }    public E removeLast(E obj) {        if (head == null) {            return null;        }        if (head == tail) {            return removeFirst(obj);        }        Node<E> current = head;        Node<E> previous = null;        while (current.next != null) {            previous = current;            current = current.next;        }        previous.next = null;        tail = previous;        currentSize--;        return current.data;    }    }