import java.util.*;

public class Main {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
  public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);

        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i] == true) {
                for(int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i < isPrime.length; i++) {
            if(isPrime[i] == true) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}