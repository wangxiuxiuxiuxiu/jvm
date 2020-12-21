package queue.demo;

import queue.CycleLinkedQueue;

public class Demo {

    public static void main(String[] args) {
        MyCircularQueue cycleLinkedQueue = new MyCircularQueue(20);

        for (int i=0;i<cycleLinkedQueue.capacity;i++){
            cycleLinkedQueue.enQueue(99);
            System.out.println("入队--数量："+cycleLinkedQueue.count);
        }

        for (int i=0;i<10;i++){
            cycleLinkedQueue.deQueue();
            System.out.println("出队--数量："+cycleLinkedQueue.count);
        }
    }
}

class Node {
    public int value;
    public Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}

class MyCircularQueue {

    private Node head, tail;
    public int count;
    public int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == this.capacity)
            return false;

        Node newNode = new Node(value);
        if (this.count == 0) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        this.count += 1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0)
            return false;
        this.head = this.head.nextNode;
        this.count -= 1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0)
            return -1;
        else
            return this.head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0)
            return -1;
        else
            return this.tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.count == this.capacity);
    }
}

