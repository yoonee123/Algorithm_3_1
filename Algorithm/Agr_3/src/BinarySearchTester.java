import java.util.*;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");

        int num = stdIn.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0]: "); // 배열의 첫 요소를 먼저 입력 받음

        x[0] = stdIn.nextInt();

        for (int i = 1; i <num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
                
                if (x[i] < x[i-1])
                    System.out.println("다시 입력 하세요 (앞의 인덱스보다 작음)");
            } while (x[i] < x[i-1]); // 바로 앞의 요소보다 작으면 다시 입력 받음
        }

        System.out.print("검색할 값: "); // 키값을 입력 받음

        int ky = stdIn.nextInt();

        // 배열 x에서 값이 ky인 요소를 검색
        int idx = Arrays.binarySearch(x, ky);

        if (idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
