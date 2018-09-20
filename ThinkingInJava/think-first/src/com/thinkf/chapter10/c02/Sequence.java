package com.thinkf.chapter10.c02;

interface Selecor {
    boolean end();
    Object currnet();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }

    }

    private class SequenceSelector implements Selecor {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object currnet() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }
    public Selecor selecor() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i =0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selecor selecor = sequence.selecor();
        while (!selecor.end()) {
            System.out.println(selecor.currnet() + " ");
            selecor.next();
        }
    }


}
