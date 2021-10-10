package com.company;

public class MyCustomDoublyLinkedList implements MyCustomList {
    Node first;
    Node last;
    int size;

    @Override
    public Object get(int index) {
        if (size() - 1 < index || index < 0) {
            throw new IllegalArgumentException("Invalid index: ");
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (size() - 1 < index || index < 0) {
            throw new IllegalArgumentException("Invalid index: ");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size() - 1) {
            removeLast();
        } else {
            Node current = first.next;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
    }


    @Override
    public boolean remove(Object obj) {
        if (size() > 0) {
            if (first.value == obj) {
                first = first.next;
                size--;
                return true;
            } else {
                Node current = first;
                for (int i = 0; i < size(); i++) {
                    if (i == size() - 1) {
                        current.next = null;
                        last = current;
                        size--;
                        return true;
                    }
                    if (current.value == obj) {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                        size--;
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object obj) {
        if (size() <= 0) {
            System.out.println("List is empty");
        }
        Node current = first.next;
        if (size() > 0) {
            if (first.value == obj) {
                return true;
            }
            for (int i = 0; i < size() - 2; i++) {
                if (current.value == obj) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void addFirst(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            first.previous = node;
            node.next = first;
            first = node;
            size++;
        }
    }

    @Override
    public void addLast(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
            size++;
        }
    }

    @Override
    public Object removeFirst() {
        if (size() <= 0) {
            throw new IllegalArgumentException("List is empty");
        } else if (size() == 1) {
            first = null;
            last = null;
            size--;
            return true;
        } else {
            first.next.previous = null;
            first = first.next;
            size--;
            return true;
        }
    }

    @Override
    public Object removeLast() {
        if (size() <= 0) {
            throw new IllegalArgumentException("List is empty");
        } else if (size() == 1) {
            first = null;
            last = null;
            size--;
            return true;
        } else {
            last.previous.next = null;
            last = last.previous;
            size--;
            return true;
        }
    }

    @Override
    public void push(Object obj) {
        addFirst(obj);
    }

    @Override
    public Object pop() {
        return removeFirst();
    }

    @Override
    public boolean offerFirst(Object obj) {
        addFirst(obj);
        return true;
    }

    @Override
    public boolean offerLast(Object obj) {
        addLast(obj);
        return true;
    }

    @Override
    public Object pool() {
        if (first == null) {
            return null;
        } else {
            Node f = first;
            first.next.previous = null;
            first = first.next;
            size--;
            return f.value;
        }
    }

    @Override
    public Object poolFirst() {
        return pool();
    }

    @Override
    public Object poolLast() {
        if (first == null) {
            return null;
        } else {
            Node l = last;
            last.previous.next = null;
            last = last.previous;
            size--;
            return l.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.value);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
