package les3.deque;

import les3.queue.IQueue;

public interface Deque<E> extends IQueue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}
