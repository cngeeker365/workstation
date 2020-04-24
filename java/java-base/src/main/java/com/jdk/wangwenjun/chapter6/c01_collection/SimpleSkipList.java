package com.jdk.wangwenjun.chapter6.c01_collection;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-21 21:42
 */
public class SimpleSkipList {
    private final static byte HEAD_NODE = (byte) -1;
    private final static byte DATA_NODE = (byte) 0;
    private final static byte TAIL_NODE = (byte) 1;
    private Node head;
    private Node tail;
    private int size;
    private int height;
    private Random random;

    public SimpleSkipList() {
        this.head = new Node(null, HEAD_NODE);
        this.tail = new Node(null, TAIL_NODE);
        head.right = tail;
        tail.left = head;
        this.random = new Random(System.currentTimeMillis());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private Node find(Integer element) {
        Node current = head;
        for (; ; ) {
            while (current.right.bit != TAIL_NODE && current.right.value <= element) {
                current = current.right;
            }
            if (current.down != null) {
                current = current.down;
            } else {
                break;
            }
        }
        return current;     //the current <= element < current.right(if exist)
    }

    public boolean contains(Integer element) {
        Node node = this.find(element);
        return (node.value == element);
    }

    public Integer get(Integer element) {
        Node node = this.find(element);
        return (node.value == element) ? node.value : null;
    }

    public void add(Integer element) {
        Node nearNode = this.find(element);
        Node newNode = new Node(element);
        newNode.left = nearNode;
        newNode.right = nearNode.right;
        nearNode.right.left = newNode;
        nearNode.right = newNode;

        int currentLevel = 0;
        while (random.nextDouble() < 0.5d) {
            if (currentLevel >= height) {
                height++;

                Node dumyHead = new Node(null, HEAD_NODE);
                Node dumyTail = new Node(null, TAIL_NODE);

                dumyHead.right = dumyTail;
                dumyHead.down = head;
                head.up = dumyHead;

                dumyTail.left = dumyHead;
                dumyTail.down = tail;
                tail.up = dumyTail;

                head = dumyHead;
                tail = dumyTail;
            }
            while ((nearNode != null) && nearNode.up == null) {
                nearNode = nearNode.left;
            }
            nearNode = nearNode.up;

            Node upNode = new Node(element);
            upNode.left = nearNode;
            upNode.right = nearNode.right;
            upNode.down = newNode;

            nearNode.right.left = upNode;
            nearNode.right = upNode;

            newNode.up = upNode;
            newNode = upNode;
            currentLevel++;
        }
        size++;
    }

    public void dumpSkipList() {
        Node temp = head;
        int i = height + 1;
        while (temp != null) {
            System.out.printf("Total [%d] height [%d]", height + 1, i--);
            Node node = temp.right;
            while (node.bit == DATA_NODE) {
                System.out.printf("->%d", node.value);
                node = node.right;
            }
            System.out.println();
            temp = temp.down;
        }
    }

    private static class Node {
        private Integer value;
        private byte bit;
        private Node up, down, left, right;

        public Node(Integer value, byte bit) {
            this.value = value;
            this.bit = bit;
        }

        public Node(Integer value) {
            this(value, DATA_NODE);
        }
    }

    public static void main(String[] args) {
        SimpleSkipList skipList = new SimpleSkipList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            skipList.add(random.nextInt(1000));
        }
        skipList.dumpSkipList();
    }
}
