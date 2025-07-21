import java.util.Scanner;

public class Numbergame{
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int num = (int)(Math.random() * 100) + 1;

        System.out.println("Welcome to the Number game");
        System.out.println("Guess correct number between 1-100");
       System.out.println("You have 5 chances to guess the number.");
        int tag=0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Guess no "+(i+1)+"  :");
            int choice=sc.nextInt();
            if(choice==num){
            System.out.println("Your guess is correct. ");
            System.out.println("You win the game. ");
            tag=1;
            break;
            }else{
                System.out.println("Wrong guess.");
                if (choice<num) {
                    System.out.println("Hint: The correct number is higher.");
                } else {
                    System.out.println("Hint: The correct number is lower.");
                }
                System.out.println("You have " + (4 - i) + " chances left.");
            }
          System.out.println("Try again");

        }
        if(tag==0){
            System.out.println("You lost the game .");
            System.out.println("Correct number is " +num);

        }
    }
}