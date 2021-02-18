package les3.deque;

import les3.queue.QueueImpl;

import java.util.Arrays;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {
    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == DEFAULT_HEAD)
            head = data.length;

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return  null;
        }
        if (tail == DEFAULT_TAIL)
            tail = data.length - 1;

        data[size-1]= null;
        size--;
        return data[tail--];


    }

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public String toString() {
        return "DequeImpl{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
