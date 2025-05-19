import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) // 배열의 반만 위치를 바꿔도 역순이 되기때문에 a배열의 길이를 받아 2로 나눔
            swap(a, i, a.length - i - 1); 
            // a배열의 끝부분부터 i값을 증가시키며 함수를 실행시키나, i만 빼면 인덱스가 배열을 초과하기때문에 -1함
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");

        int num = stdIn.nextInt(); 

        int[] x = new int[num]; 

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        
        reverse(x); // x는 배열의 주소를 담고있고 reverse함수에서 인자를 배열로 받기때문에 x만 전달함
        
        System.out.println("요소를 역순으로 정렬했습니다.");
        System.out.println("x = " + Arrays.toString(x));
        }
    }