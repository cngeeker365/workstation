package com.jdk.wangwenjun.chapter6.c01_collection;

/**
 * @author taobaibai
 * @create 2020-04-21 21:42
 */
public class PriorityLinkedList<E extends Comparable<E>>{
    private final static String PLAIN_NULL = "null";
    private Node<E> first;
    private final Node<E> NULL = (Node<E>) null;
    private int size;

    public PriorityLinkedList(){
        this.first = NULL;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return 0 == size();
    }
    public PriorityLinkedList<E> addFirst(E e){
        final Node<E> newNode = new Node<>(e);
        Node<E> previous = NULL;
        Node<E> current = first;
        while (current!=null && e.compareTo(current.value)>0){
            previous = current;
            current = current.next;
        }
        if(previous==NULL){
            first = newNode;
        }else {
            previous.next = newNode;
        }
        newNode.next = current;
        this.size++;
        return this;
    }
    public static <E extends Comparable<E>> PriorityLinkedList<E> of(E... elements){
        final PriorityLinkedList<E> list = new PriorityLinkedList<>();
        if(elements.length!=0){
            for(E e: elements){
                list.addFirst(e);
            }
        }
        return list;
    }
    public boolean contains(E e){
        Node<E> current = first;
        while(current!=null){
            if(current.value == e){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public E removeFirst(){
        /**
         * Also return the NULL always when the linked list is empty
         */
        if(this.isEmpty()){
            throw new NoElementException("The linked list is empty.");
        }
        Node<E> node = first;
        first = node.next;
        size--;
        return node.value;
    }
    @Override
    public String toString() {
        if(this.isEmpty()){
            return "[]";
        }else {
            StringBuilder builder = new StringBuilder("[");
            Node<E> current = first ;
            while (current!=null){
                builder.append(current.toString()).append(",");
                current = current.next;
            }
            builder.replace(builder.length()-1, builder.length(), "]");
            return builder.toString();
        }
    }

    static class NoElementException extends RuntimeException{
        public NoElementException(String message) {
            super(message);
        }
    }
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if(null != value){
                return value.toString();
            }
            return PLAIN_NULL;
        }
    }

    public static void main(String[] args) {
        PriorityLinkedList<Integer> list = PriorityLinkedList.of(10, 1, -10, 0, 100, 90, 88, 2);
        System.out.println(list);
    }
}
