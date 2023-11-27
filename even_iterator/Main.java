package even_iterator;

import java.util.Iterator;

class EnclosingClassOfEvenIterator {
    int[] data;

    EnclosingClassOfEvenIterator(int[] data) {
        this.data = data;
    }

    Iterator<Integer> getEvenIterator() {
        return new EvenIterator();
    }

    private class EvenIterator implements Iterator<Integer> {
        int index = 0;

        @Override
        public boolean hasNext() {
            while (index < data.length && data[index] % 2 != 0) {
                index++;
            }
            return index < data.length;
        }

        @Override
        public Integer next() {
            int value =  data[index];
            index++;
            return value;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        EnclosingClassOfEvenIterator enclosing = new EnclosingClassOfEvenIterator(data);

        Iterator<Integer> evenIterator = enclosing.getEvenIterator();

        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }
}
