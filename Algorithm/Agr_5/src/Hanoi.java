import java.util.*;

class Hanoi {
    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) // 함수가 스택처럼 쌓인다고 보면됨
    {
        if (no > 1)
            move(no-1, x, 6-x-y); // 이 안에 있는 move가 자체적으로 호출되어서 조건을 지나치면 프린트 문이 실행됨
        
        System.out.printf("원반[%d]를 %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);
        // 재귀 호출을 통해 가장 작은 원반(no == 1)에 도달했을 때
        // 그 시점의 move 함수가 먼저 실행되고, 그 이후에 상위 함수들로 돌아오며
        // 각 단계의 출력문이 차례로 실행됨

        if (no > 1)
            move(no-1, 6-x-y, y);
    }

    // 3, 1, 3
    // 2, 1, 2(6-4)
    // 1, 1, 3(6-4) * 출력
    // 재귀
    // 2, 1, 2 * 출력 (첫 if 건너뜀)
    // 1, 3(6-3), 2 * 출력
    // 재귀
    // 3, 1, 3 * 출력 (첫 if 건너뜀)
    // 2, 2(6-4), 3
    // 1, 2, 1(6-5) * 출력
    // 재귀
    // 2, 2, 3 * 출력 (첫 if 건너뜀)
    // 1, 1(6-5), 3 * 출력

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("하노이의 탑");
        System.err.print("원반의 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3); // 제 1 기둥에 쌓인 n개를 제 3 기둥으로 옮김
    }
}