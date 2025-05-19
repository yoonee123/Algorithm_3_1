import java.util.*;

class BubbleSort {
    static void swap(int[] a, int idx1, int idx2)
    {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }


    static void bubbleSort(int[] a, int n) { // 정렬할 정수 배열 a, 요솟수 n
            // BubbleSort (ver 1)
        // for (int i = 0; i < n-1; i++) // i는 맨 마지막 인덱스를 갈 필요가 없음
        //     for (int j = n - 1; j > i; j--) // j의 인덱스가 배열의 크기를 초기화하지 않기 위해 n-1
        //         if(a[j - 1] > a[j])
        //             swap(a, j-1, j);;

            // BubbleSort (ver 2) // swap이 한번이라도 일어나지 않았다면 이미 정렬 된 배열
        // for (int i = 0; i < n-1; i++)
        // {
        //     int exchg = 0;
        //     for (int j = n-1; j > i; j--)
        //         if (a[j -1] > a[j])
        //         {
        //             swap(a, j-1, j); 
        //             exchg++;
        //         }
        //     if (exchg == 0) 
        //     break;
        // }

            // BubbleSort (ver 3)
        // int k = 0;
        // while (k < n -1) {
        //     int last = n-1;
        //     for(int j = n -1; j > k; j--) 
        //     // 마지막 인덱스를 기준으로 삼고 첫번째 인덱스까지 반복문으로 비교함
        //     {
        //         if(a[j-1] > a[j])
        //         {
        //             swap(a, j-1, j); // 변환한 뒷쪽 인덱스가 last값으로 선언됨
        //             last = j;
        //         }
        //     }
        //     k = last; // 증가한 last값에 따라 while문이 실행 되야 할 횟수를 줄임
        // }
        // 예시 :
        // {5, 2, 3, 4, 1}
        // 1부터 순회를 하며 2, 3, 4는 swap이 일어나지 않음
        // 5와 스왑이 되면서 1의 인덱스인 4가 k값으로 전달됨
        // 오름차순으로 정렬 된 상태에서 while(k < n - 1)가 일치하지 않기 때문에 종료됨

            // SelectionSort
        // for (int i = 0; i < n-1; i++)
        // {
        //     // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 저장
        //     int min = i;
        //     for (int j = i + 1; j < n; j++)
        //         if (a[j] < a[min])
        //             min = j;
        //     // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
        //     swap(a, i, min);
        // }

            // InsertionSort
        // for (int i = 1; i < n; i++) // 두번째 인덱스부터 순회를 시작
        // {
        //     int j;
        //     int tmp = a[i]; // 두번째 인덱스의 값을 tmp에 넣음
        //     // j가 첫번째 인덱스 이후임과 동시에 tmp 바로 앞의 인덱스(* [j-1])가 tmp보다 작을 경우 반복문 실행
        //     for (j = i; j > 0 && a[j - 1] > tmp; j--) 
        //         a[j] = a[j - 1];
        //     a[j] = tmp;
        // }

        //         처음:  [3, 5, 1, 4, 2]
        //                       ↑ tmp

        // 1단계: [3, 5, 5, 4, 2]  // 5 → 밀림
        // 2단계: [3, 3, 5, 4, 2]  // 3 → 밀림
        //     ↓
        //     tmp 들어갈 자리 발견 → a[0] = 1

        // 최종:  [1, 3, 5, 4, 2]


            // ShellSort (ver 1) ex) 배열의 크기가 8일 경우
        for (int h = n / 2; h > 0; h/=2) // 반으로 줄여서 4가 됨
            for (int i = h; i < n; i++) // 4에서 점점 증가함 4,5,6,7
            {
                int j;
                int tmp = a[i];  // 1. (a[4]값이 tmp에 들어감) 2. (a[5]값이 tmp에 들어감)
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                a[j + h] = a[j];
                // 조건이 만족했을 경우 (보통은 스왑을 해야 하는 경우)
                // 1. (j는 0이 되고, j + h는 4가 됨) 2. (j는 1이 되고, j + h는 5가 됨)
                // 1. (j = -4가 되기때문에 반복문을 빠져나옴) 2. (j = -3이 되기때문에 반복문 빠져나옴)
                a[j + h] = tmp;
                // 1. (a[-4 + 4] = a[4]) 2. (a[-3 + 4] = a[5])
                // 3중 반복문 중 두번째로 향함
            } 
            // 위와 같은 로직을 반복하고 h를 반으로 줄여 간격을 줄임 
            // ex(0, 4 - 1, 5 - 2, 6... ) -> (0, 2 - 1, 3 - 2, 4...) -> (0, 1 - 1, 2 - 2, 3...)

            // ShellSort(ver 2) // 간격이 매우 커보이지만 knuth의 간격은 수학적으로 최적화 된 간격
            // 셸 정렬을 이해하고 있을 경우 knuth의 공식만 외우고 있으면 됨
        // int h;
        // for (h = 1; h < n; h = h * 3 + 1);
        // for ( ; h > 0; h /= 3)
        //     for (int i = h; i < n; i++)
        //     {
        //         int j;
        //         int tmp = a[i];
        //         for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
        //             a[j + h] = a[j];
        //         a[j + h] = tmp;
        //     }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        // System.out.println("버블 정렬(버전 1)");
        // System.out.println("버블 정렬(버전 2)");
        // System.out.println("버블 정렬(버전 3)");
        // System.out.println("선택 정렬");
        // System.out.println("삽입 정렬");
        // System.out.println("셀 정렬(버전 1)");
        // System.out.println("셀 정렬(버전 2)");

        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) 
        {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        
        bubbleSort(x, nx); // 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
        }  
}