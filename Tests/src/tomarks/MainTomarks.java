package tomarks;

import java.util.Scanner;

public class MainTomarks {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Account account = new Account();
            account.inputAccount();
            System.out.print("Deposit (0) or Withdraw (1): ");
            int type = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount of money ($): ");
            long amount = Integer.parseInt(scanner.nextLine());
            account.depositAndWithdraw(amount, type);
            System.out.println(account);
    }
}
