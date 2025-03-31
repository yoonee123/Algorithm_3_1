import java.util.*;

public class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStack(int maxlen) {
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
    
    private boolean isFull() {
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
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println();
                System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
                System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료:");

                int menu = stdIn.nextInt();
                if (menu == 0) break;

                int x;
                switch (menu) {
                    case 1:
                        System.out.print("데이터: ");
                        x = stdIn.nextInt();
                        try {
                            s.push(x);
                        } catch (IntStack.OverflowIntStackException e)
                        {
                            System.out.println("스택이 가득 찼습니다.");
                        }
                        break;

                    case 2:
                        try {
                            x = s.pop();
                            System.out.println("팝한 데이터는" + x + "입니다.");
                        } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                        }
                        break;

                    case 3:
                        try {
                            x = s.peak();
                            System.out.println("피크한 데이터는 " + x + "입니다.");
                        } catch (IntStack.EmptyIntStackException e) {
                            System.out.println("스택이 비어있습니다.");
                        }
                        break;

                    case 4:
                        s.dump();
                        break;
                }
        }
    }
}