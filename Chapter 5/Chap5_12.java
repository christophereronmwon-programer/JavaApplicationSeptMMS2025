import java.util.Random;

public class Chap5_12 {
    public static void main(String[] args) {
        Random rand = new Random();

        // a) 1 <= n <= 2
        int nA = 1 + rand.nextInt(2); 

        // b) 1 <= n <= 100
        int nB = 1 + rand.nextInt(100); 

        // c) 0 <= n <= 9
        int nC = rand.nextInt(10); 

        // d) 1000 <= n <= 1112
        int nD = 1000 + rand.nextInt(113); 

        // e) -1 <= n <= 1
        int nE = -1 + rand.nextInt(3); 

        // f) -3 <= n <= 11
        int nF = -3 + rand.nextInt(15); 

        System.out.printf("a) Range [1, 2]:      %d%n", nA);
        System.out.printf("b) Range [1, 100]:    %d%n", nB);
        System.out.printf("c) Range [0, 9]:      %d%n", nC);
        System.out.printf("d) Range [1000, 1112]:%d%n", nD);
        System.out.printf("e) Range [-1, 1]:     %d%n", nE);
        System.out.printf("f) Range [-3, 11]:    %d%n", nF);
    }
}