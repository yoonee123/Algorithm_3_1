import java.util.*;

public class IntQueue {
    private int[] que;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntStackException {
        if (num >= capacity)
            throw new OverflowIntStackException();
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0;
        return x;
    }

    public int deque() throws EmptyIntStackException {
        if (num <= 0)
            throw new EmptyIntStackException();
        int x = que[front++];
        num--;
        if (front == capacity)
            front = 0;
        return x;
    }

    public int peak() throws EmptyIntStackException {
        if (num <= 0)
            throw new EmptyIntStackException();
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
        {
            int idx = (i + front) % capacity;
            if (que[idx] == x)
            return idx; 
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }
    
    private boolean isFull() {
        return num >= capacity;
    }

    public void dump () {
        if (num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < num; i++)
            {
                System.out.print(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}

class IntQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        while (true) {
        System.out.println(" ");
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.err.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntStackException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                
                case 2: 
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntStackException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peak();
                        System.out.print("피크한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntStackException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
