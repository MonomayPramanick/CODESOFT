import java.util.Scanner;

public class Student_Grade_System {
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int num = sc.nextInt();
        int marks[]=new int[num];
        int tot=0;
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject "+(i + 1)+" (out of 100): ");
            marks[i]=sc.nextInt();
            tot+=marks[i];
        }

        double avg=(double)tot/num;
        String grade;
        if(avg>=90){
            grade="A+";
        }else if(avg>=80){
            grade="A";
        }else if(avg>=70){
            grade="B";
        }else if (avg>=60) {
            grade="C";
        }else if(avg>=50){
            grade="D";
        }else{
            grade="F";
        }

        System.out.println("----------Result----------");
        System.out.println("Total Marks : "+ tot);
        System.out.println("Average percentage : "+avg+" % ");
        System.out.println("Grade : "+grade);

    }
}
