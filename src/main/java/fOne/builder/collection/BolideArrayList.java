package fOne.builder.collection;

@SuppressWarnings("unchecked")
public class BolideArrayList<T> {
    private Object[] data = new Object[2];
    private int size = 0;

    public void add(T value) {
        if (size == data.length) {
            Object[] bigger = new Object[data.length * 2];
            for (int i = 0; i < size; i++) bigger[i] = data[i];
            data = bigger;
        }
        data[size] = value;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index);
        return (T) data[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index);
        T removed = (T) data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        data[size - 1] = null;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index: " + index);
        data[index] = value;
    }
}