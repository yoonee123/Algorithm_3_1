import java.util.*;

class CountingSort {
    // 도수 정렬(배열 요소의 값은 0 이상 max 이하)
    static void CountingSort(int[] a, int n, int max)
    {
        int[] f = new int[max + 1]; // 누적 도수
        int[] b = new int[n]; // 작업용 목표 배열

        // [Step 1]
        for (int i = 0; i < n; i++) f[a[i]]++;
        // [Step 2] 
        for (int i = 1; i <= max; i++) f[i] += f[i - 1];
        // [Step 3]
        for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
        // [Step 4]
        for (int i = 0; i < n; i++) a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) 
        {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] > max) max = x[i];

        CountingSort(x, nx, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}