import java.util.Scanner;

public class SeqSearch {
    static int SeqSearch(int [] a, int n, int key) { // 정렬 필요 없고 느리지만 단순함
        // int i = 0;

        // while (true)
        // {
        //     if (i == n)
        //         return -1;
        //     if (a[i] == key)
        //         return i;
        //     i++;
        // }
    
        // for (int i = 0; i < n; i++)
        //     if (a[i] == key)
        //         return i;
        // return -1;
        int i = 0;
        
        a[n] = key;

        while (true) 
        {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++)
        {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }
        
        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();
        int idx = SeqSearch(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}

