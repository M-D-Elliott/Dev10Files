package com.sg.referencedata.objects;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> curr;
    private int size;

    public void add(T item) {

        if (head == null) {
            head = new Node<>(item, null);
            tail = head;
        } else {
            tail.setNext(new Node<>(item, null));
            tail = tail.getNext();
        }

        size++;
    }

    // Adds an item at the given index.
    // Items after should "shift". Nothing is replaced.
    // Should throw an IndexOutOfBoundsException if index
    // is "past" the end of the list or negative.
    public void addAt(int index, T item) throws OutOfRangeException {
        iterate(index);
        Node<T> newNode = new Node<>(item, curr.getNext());
        
        curr.setNext(newNode);
        size++;
    }

    // Returns true if the given item is in our list
    // else, false.
    public boolean contains(T item){
        curr = head;
        while(curr.getNext() != null) {
            if(curr.getValue() == item){
                return true;
            }
        }
        return false;
    }

    // Returns the item at a given index.
    // Should throw an IndexOutOfBoundsException if index
    // is "past" the end of the list or negative.
    public T get(int index) throws OutOfRangeException {
        iterate(index);
        return curr.getValue();
    }

    // Replaces the item at index with a new item.
    // Should throw an IndexOutOfBoundsException if index
    // is "past" the end of the list or negative.
    public void set(int index, T item) throws OutOfRangeException {
        iterate(index - 1);
        Node<T> newNode = new Node<>(item, curr.getNext().getNext());
        
        curr.setNext(newNode);
    }

    // Removes the given item from our list.
    // Returns true if found, else false.
    public boolean remove(T item) {
        if(contains(item)){
            
        }
        Node<T> temp = curr.getNext();
        size--;
        return true;
    }

    // Removes an item at the given index
    // and returns it.
    // Should throw an IndexOutOfBoundsException if index
    // is "past" the end of the list or negative.
    public T removeAt(int index) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        for (Node<T> cursor = head; cursor != null; cursor = cursor.getNext()) {
            System.out.println(cursor.getValue());
        }
    }

    public int size() {
        return size;
    }

    private void iterate(int index) throws OutOfRangeException {
        curr = head;
        for (int i = 0; i < index - 1; i++) {
            if(curr.getNext() != null){
                curr = curr.getNext();
            } else {
                throw new OutOfRangeException("Index " + index + " is out of bounds for length " + size + ".");
            }
        }
    }
}