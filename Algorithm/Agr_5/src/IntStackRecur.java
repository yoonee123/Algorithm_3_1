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
        // 배열에 들어있는 값들을 하나씩 팝하면서 출력 
        // 1, 2, 3 ...
        // 팝한 값을 비교해서 0보다 작으면 반복문 탈출
        // 만약 팝한 값의 -2가 0보다 클 경우, n - 2를 다시 반복문에 넘겨 양수일 경우 푸시
        // 푸시 된 값을 다시 팝함
        // n = n - 2는 팝한 값을 대상으로 한 로직임. 배열에 영향 X 
    }   

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);    

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
