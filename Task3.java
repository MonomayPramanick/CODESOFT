import java.util.Scanner;

class BankAcc{
    private double bal;
    public BankAcc(double init){
        this.bal=init;
    }
    public double getBalance(){
        return bal;
    }

    public boolean withdraw(double amt){
        if(amt<=bal){
            bal-=amt;
            return true;
        }
        return false;
    }
    public boolean deposit(double amt){
        if (amt>0) {
            bal+=amt;
            return true;
        }else{
            return false;
        }
    }
}


class ATM{
    private BankAcc acc;
    public ATM(BankAcc acc){
        this.acc=acc;
    }
    public void showMenu(){
        Scanner sc=new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
             while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (acc.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn: $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                    case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (acc.deposit(depositAmount)) {
                        System.out.println("Deposited: $" + depositAmount);
                    } else {
                        System.out.println("Invalid amount. Try again.");
                    }
                    break;
                    case 3:
                    System.out.println("Current Balance: $" + acc.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 4);
        sc.close();

    }
}




public class Task3 {
    
    public static void main(String[] args) {
        BankAcc userAcc=new BankAcc(1000.0);
        ATM atm=new ATM(userAcc);
        atm.showMenu();    
    }
}
