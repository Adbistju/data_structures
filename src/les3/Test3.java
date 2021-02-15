package les3;

import com.sun.jdi.CharValue;
import les3.deque.DequeImpl;
import les3.queue.IQueue;
import les3.queue.PriorityQueueImpl;
import les3.stack.IStack;
import les3.stack.StackImpl;

import java.nio.charset.Charset;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
//        testQueue();
        testDequeue();
        overturnSring();

    }

    private static void testStack() {
        IStack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());
        stack.display();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static boolean addToStack(IStack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
 //       IQueue<Integer> queue = new QueueImpl<>(5);
        IQueue<Integer> queue = new PriorityQueueImpl<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testDequeue(){
        DequeImpl<Integer> deque = new DequeImpl<>(5);

        for (int i = 0; i < 5; i++) {
            deque.insertLeft(i+1);
            System.out.println(deque.toString());
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 5; i++) {
            deque.removeLeft();
            System.out.println(deque.toString());
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 5; i++) {
            deque.insertRight(i+1);
            System.out.println(deque.toString());
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 5; i++) {
            deque.removeRight();
            System.out.println(deque.toString());
        }
        System.out.println("--------------------------------------------");
        boolean b = true;
        for (int i = 0; i < 5; i++) {
            if(b){
                deque.insertRight(i);
                System.out.println(deque.toString());
                b = false;
            } else {
                deque.insertLeft(i);
                System.out.println(deque.toString());
                b = true;
            }
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 5; i++) {
            deque.removeRight();
            System.out.println(deque.toString());
        }
        System.out.println("--------------------------------------------");
        b = true;
        for (int i = 0; i < 5; i++) {
            if(b){
                deque.insertRight(i);
                System.out.println(deque.toString());
                b = false;
            } else {
                deque.insertLeft(i);
                System.out.println(deque.toString());
                b = true;
            }
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < 5; i++) {
            deque.removeLeft();
            System.out.println(deque.toString());
        }


    }

    private static void overturnSring(){
        System.out.println();
        System.out.println("overturnSring()");
        System.out.println();

        String str = "gnirtS ruoy";

        System.out.println(str);

        char[] overturnStr = str.toCharArray();

        IStack<Character> stack = new StackImpl<>(overturnStr.length);

        for (int i = 0; i < overturnStr.length; i++) {
            stack.push(overturnStr[i]);
        }

        for (int i = 0; i < overturnStr.length; i++) {
            System.out.print(stack.pop());
        }
    };
}
