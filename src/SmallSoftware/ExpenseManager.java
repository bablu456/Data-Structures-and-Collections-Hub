package SmallSoftware;

import java.util.Scanner;

public class ExpenseManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n=== 💰 MY EXPENSE MANAGER ===");
            System.out.println("1. Add Expense (Kharcha Jodo)");
            System.out.println("2. View All (Hisaab Dekho)");
            System.out.println("3. Total Summary (Kul Kharcha)");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Feature coming soon...");
                    break;
                case 2:
                    System.out.println("List is empty.");
                    break;
                case 3:
                    System.out.println("Total: ₹0");
                    break;
                case 4:
                    System.out.println("Bye Bye! 👋");
                    System.exit(0);
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}
