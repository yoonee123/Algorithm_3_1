import java.util.*;

class BubbleSort {
    static void swap(int[] a, int idx1, int idx2)
    {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }


    static void bubbleSort(int[] a, int n) {
            // BubbleSort (ver 1)
        // for (int i = 0; i < n-1; i++)
        //     for (int j = n - 1; j > i; j--)
        //         if(a[j - 1] > a[j])
        //             swap(a, j-1, j);;

            // BubbleSort (ver 2)
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
        //         if(a[j-1] > a[j])
        //         {
        //             swap(a, j-1, j);
        //             last = j;
        //         }
        //     k = last;
        // }

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
        // for (int i = 1; i < n; i++) 
        // {
        //     int j;
        //     int tmp = a[i];
        //     for (j = i; j > 0 && a[j - 1] > tmp; j--)
        //         a[j] = a[j - 1];
        //     a[j] = tmp;
        // }

            // ShellSort (ver 1)
        // for (int h = n / 2; h > 0; h/=2)
        //     for (int i = h; i < n; i++)
        //     {
        //         int j;
        //         int tmp = a[i];
        //         for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
        //             a[j + h] = a[j];
        //         a[j + h] = tmp;
        //     }

            // ShellSort(ver 2)
        int h;
        for (h = 1; h < n; h = h * 3 + 1);
        for ( ; h > 0; h /= 3)
            for (int i = h; i < n; i++)
            {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        // System.out.println("버블 정렬(버전 1)");
        // System.out.println("버블 정렬(버전 2)");
        // System.out.println("버블 정렬(버전 3)");
        // System.out.println("선택 정렬");
        // System.out.println("삽입 정렬");
        // System.out.println("셀 정렬(버전 1)");
        System.out.println("셀 정렬(버전 2)");

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