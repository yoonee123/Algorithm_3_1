import java.util.*;

public class BinSearch {
    static int binSearch(int[] a, int n, int key) { // 정렬되어있어야하고 직접 구현하는 이진 탐색
        int pl = 0; // 검색 범위의 첫 인덱스
        int pr = n-1; // 검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2; // 중앙 요소의 인덱스
            if (a[pc] == key)
                return pc; // 검색 성공
            else if (a[pc] < key)
                pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 좁힘 (pl의 값을 1 더하면 오른쪽으로 한칸 밀림. 중앙 인덱스가 오른쪽으로 1 밀림)
            else
                pr = pc - 1; // 검색 범위를 앞쪽 절반으로 좁힘 (pl의 값을 1 줄여 왼쪽으로 한칸 밀림. 중앙 인덱스가 왼쪽으로 1 밀림)
        } while (pl <= pr);
        return -1; 

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수 : ");

        int num = stdIn.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0]: "); // 첫 요소 입력받음

        x[0] = stdIn.nextInt();

        for (int i =1; i < num; i++) 
        {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();

                if (x[i] < x[i-1])
                    System.out.println("다시 입력 하세요 (앞의 인덱스보다 작음)");
            } while (x[i] < x[i-1]); // 바로 앞의 요소보다 작으면 다시 입력 받음
        }

        System.out.print("검색할 값 : "); // 키값을 입력받음

        int ky = stdIn.nextInt();

        // 배열 x에서 값이 ky인 요소를 검색
        int idx = binSearch(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 [" + idx + "] 에 있습니다.");
    }
}

