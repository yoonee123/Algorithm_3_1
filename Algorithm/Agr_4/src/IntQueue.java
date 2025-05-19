import java.util.*;

public class IntQueue {
    private int[] que; // 큐 본체
    private int capacity; // 큐의 최대 용량
    private int front; // 맨 앞 요소의 인덱스
    private int rear; // 맨 끝 요소의 다음 인덱스
    private int num; // 현재 큐에 저장된 데이터 수

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
        que[rear++] = x; // 입력받은 x값을 que에 저장한 다음, rear값을 증가시킴
        num++; // 저장된 데이터 수도 증가
        if (rear == capacity)
            rear = 0; 
        // 저장된 데이터 수가 배열의 크기와 같아졌을 때, 
        // 원형적인 기능을 하기 위해 rear값을 0을 초기화
        // 배열이 가득 찬 상태에서 디큐를 하지 않고 인큐를 할 경우 예외처리가 바로 발생함
        return x;
    }

    public int deque() throws EmptyIntStackException {
        if (num <= 0)
            throw new EmptyIntStackException();
        int x = que[front++]; // 큐의 맨 앞 인덱스는 x(쓰레기통)에 저장되고, 인덱스가 증가함
        num--; // 데이터 수는 감소했기 때문에 num은 capacity와 같아 질수 없음
        if (front == capacity)
            front = 0;
        // 만약 디큐가 끝까지 도달했을 경우, 인큐를 새로했을 때 0번부터 디큐를 해야하기 때문에 초기화
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
        // 디큐를 할 경우 어차피 num값이 감소하기 때문에, 디큐한 쓰레기값까지 접근 불가
        {
            int idx = (i + front) % capacity;
            // 5 크기의 배열에서 디큐를 2번한 경우
            // (0 + 2) % 5 == que[2]
            // (1 + 2) % 5 == que[3]
            // (2 + 2) % 5 == que[4]
            // num 값을 감소시켜 3이기 때문에 반복문 탈출

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
