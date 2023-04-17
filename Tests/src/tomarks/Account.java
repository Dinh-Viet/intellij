package tomarks;

import javax.xml.namespace.QName;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String customerCode;
    private String customerNanme;
    private int accNumber;
    private long amount;


    public void inputAccount() {
        Scanner scanner = new Scanner(System.in);
        boolean isCustomerCodeValid = false;
        boolean isAccNumberValid = false;

        while (!isCustomerCodeValid) {
            System.out.print("Enter customer code: ");
            String codes = scanner.nextLine();

            if (codes.length() != 5) {
                System.out.print("Codes must be charaters");
                continue;
            }
            isCustomerCodeValid = true;
            customerCode = codes;
        }
        System.out.print("Enter customerName");
        customerNanme = scanner.nextLine();
        while (!isAccNumberValid) {
            System.out.print("Enter accNumber: ");
            String Number = scanner.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(Number);

            if (!matcher.matches()) {
                System.out.println("accNumber must be a number");
                continue;
            }
            if (Number.length() != 6) {
                System.out.println("accNumber must be 6 digits");
                continue;
            }
            if (!Number.startsWith("100")) {
                System.out.println("accNumber must start with 100");
                continue;
            }
            isAccNumberValid = true;
            accNumber = Integer.parseInt(Number);
        }
    }
    public void depositAndWithdraw(long amount, int type) {
        if (type == 0) {
            if (amount < 0) {
                System.out.println("Amount must be a positive number");
                return;
            }
            this.amount += amount;
            return;
        }
        if (amount > 0 && amount < this.amount) {
            this.amount -= amount;
            return;
        }
        System.out.println("Non-sufficient funds");
    }

    @Override
    public String toString() {
        return String.format("customerCode = %s customerName = %s accNumber = %d amount = %d", customerCode, customerNanme, accNumber, amount);
    }
}
