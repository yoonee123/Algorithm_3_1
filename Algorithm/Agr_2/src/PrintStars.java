import java.util.Scanner;

public class PrintStars {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n, w;

        System.out.println("*을 n개를 출력하되 w개마다 줄을 바꿔서 출력합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w값: ");
            w = stdIn.nextInt();
        } while (w <= 0 || w > n);

        for (int i = 0; i < n / w; i++) // 10(n) / 4(w) 2번 줄바꿈, 4(w)개 출력력
            System.out.println("*".repeat(w)); // repeat 메서드는 프린트문 그 자체를 반복한다고 생각해야함

        int rest = n % w; // 10(n) % 4(w) = rest(2) 나머지 출력력

        if (rest != 0)
            System.out.println("*".repeat(rest));
    }
}