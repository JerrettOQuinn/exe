package com.oquinn;

class Empty extends Exception {}
class Full extends Exception {}


class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int current = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void push(E element ) throws Full {
        if (index >= size) {
            throw new Full();
        }

        elements[index] = element;
        index++;
    }

    E pop () throws Empty {
        if (index == 0) {
            throw new Empty();
        }

        E returnElement = elements[current];
        current++;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.push("string1");
            strings.push("string2");
            System.out.println(strings.pop());
            System.out.println(strings.pop());
        } catch (Full | Empty e) {
            e.printStackTrace();
        }

    }
}
