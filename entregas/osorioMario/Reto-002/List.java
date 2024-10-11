package listas.basica;

import java.util.List;

public class List {
    private Node first = null;
    private int count = 0;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        count++;
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            n.setNext(this.first);
            this.first = n;
        }
        count++;
    }

    public void deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
                this.first = null;
            } else {
                Node iterator = this.first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null);
            }
            count--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            count--;
        }
    }

    public void deleteAll() {
        this.first = null;
        count = 0;
    }

    public List find(String value) {
        List matches = new List();
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                matches.insertEnd(iterator.getValue());
            }
            iterator = iterator.getNext();
        }
        return matches;
    }

    public List listAll() {
        List list = new List();
        Node iterator = this.first;
        while (iterator != null) {
            list.insertEnd(iterator.getValue());
            iterator = iterator.getNext();
        }
        return list;
    }
}
