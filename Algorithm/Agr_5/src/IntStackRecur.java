import java.util.*;

public class IntStackRecur {
    private int[] stk;
    private int capacity;
    private int ptr;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStackRecur(int maxlen) {
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

    public boolean isEmpty() {
        return ptr <= 0;
    }
}

class RecurX2 {
    static void recur(int n) {
        IntStackRecur s = new IntStackRecur(n);
    
        while (true) {
            if (n > 0) {
                s.push(n);
                n = n-1;
                continue;
            }
            if (s.isEmpty() != true) {
                n = s.pop();
                System.out.println(n);
                n = n-2;
                continue;
            }
            break;
        }
    }   

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);    

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
