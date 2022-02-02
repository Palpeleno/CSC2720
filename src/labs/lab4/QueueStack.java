package labs.lab4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {

    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();

    public static int curr_size;

    QueueStack() {
        curr_size = 0;
    }

    void push(int x) {
        curr_size++;

        // Push x first in empty q2
        q2.add(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void pop() {

        // if no elements are there in q1
        if (q1.isEmpty())
            return;
        q1.remove();
        curr_size--;
    }

    int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    int size() {
        return curr_size;
    }
}
