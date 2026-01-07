package SmallSoftware;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    static List<Expense> expenseList = new ArrayList<>();

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
                    System.out.print("Kahan kharch kiya? (Desc): ");
                    String desc = sc.nextLine();
                    System.out.print("Kitna udaya? (Amount): ");
                    double amount = sc.nextDouble();
                    expenseList.add(new Expense(desc, amount));
                    System.out.println("✅ Added!");                    break;
                case 2:
                    System.out.println("--- YOUR KHARCHA ---");
                    for(Expense e : expenseList) {
                        System.out.println(e);
                    }                    break;
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
    static class Expense{
        String description;
        double amount;

        public Expense (String description, double amount){
            this.description = description;
            this.amount = amount;
        }
    }
}
