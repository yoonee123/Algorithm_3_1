import java.util.*;

public class IntStackTestEx {
    private int[] stk;
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStackTestEx(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int peak() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public void clear() {
        ptr = 0;
    }

    public int indexOf(int x) {
        for (int i = ptr-1; i >= 0; i--)
        {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }
    
    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump () {
        if (ptr <= 0)
            System.out.println("스택이 비었습니다.");
        else {
            for (int i = 0; i < ptr; i++)
            {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}

class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStackTestEx s = new IntStackTestEx(64);

        while (true) {
            System.out.println();
                System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
                System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)클리어 (6)인덱스 (7) 엠티 (8) 풀 (0)종료:");

                int menu = stdIn.nextInt();
                if (menu == 0) break;

                int x;
                switch (menu) {
                    case 1:
                        System.out.print("데이터: ");
                        x = stdIn.nextInt();
                        try {
                            s.push(x);
                        } catch (IntStackTestEx.OverflowIntStackException e)
                        {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        break;

                    case 2:
                        try {
                            x = s.pop();
                            System.out.println("팝한 데이터는" + x + "입니다.");
                        } catch (IntStackTestEx.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                        }
                        break;

                    case 3:
                        try {
                            x = s.peak();
                            System.out.println("피크한 데이터는 " + x + "입니다.");
                        } catch (IntStackTestEx.EmptyIntStackException e) {
                            System.out.println("스택이 비어있습니다.");
                        }
                        break;

                    case 4:
                        s.dump();
                        break;

                    case 5:
                        s.clear();
                        System.out.println("스택을 클리어했습니다.");
                        break;
                    case 6:
                        System.out.print("데이터: ");
                        x = stdIn.nextInt();
                        int idx = s.indexOf(x);
                        if(idx < 0)
                        {
                            System.out.println("데이터가 스택에 없습니다.");
                        }
                        else
                        {
                            System.out.println("데이터의 인덱스는 " + idx + "입니다.");
                        }
                    case 7:
                        if(s.isEmpty())
                        {
                            System.out.println("스택이 비었습니다.");
                        }
                        else
                        {
                            System.out.println("스택이 비지 않았습니다.");
                        }
                        break;
                    case 8:
                        if(s.isFull())
                        {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        else    
                        {
                            System.out.println("스택이 가득 차지 않았습니다.");
                        }
                        break;
                }
        }
    }
}