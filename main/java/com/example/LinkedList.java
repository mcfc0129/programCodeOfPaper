package com.example;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;
    private int size;

    public LinkedList() {
        head = crnt = null;
        size = 0;
    }

    public String toString() {
        Node<E> ptr = head;
        String str = "[";
        while (ptr != null) {
            str += ptr.data + " ";
            ptr = ptr.next;
        }
        str += "]";
        return str;
    }

    public int size() {
        size = 0;
        Node<E> ptr = head;

        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }
        return size;
    }

    public E get(int i) {
        Node<E> ptr = head;
        int counter = 0;
        while (ptr != null) {
            if (counter == i) {
                crnt = ptr;
                return ptr.data;
            }
            counter++;
            ptr = ptr.next;
        }
        return null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contain(E data, Comparator<? super E> c) {
        Node<E> ptr = head;
        while (ptr != null) {
            if (c.compare(data, ptr.data) == 0) {
                crnt = ptr;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);

        }
    }

    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                Node<E> pre = head;
                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) {
                        return;
                    }
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
        // size--;
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
        crnt = null;
        size = 0;
    }

    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("着目ノードはありません");
        } else {
            System.out.println(crnt.next);
        }
    }

    public void dump() {
        Node<E> ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}

