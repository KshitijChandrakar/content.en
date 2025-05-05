/*
?
###
?????
#######
?????????
*/
import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number Of Lines: ");
        int lines = scanner.nextInt();
        scanner.close();
        String[] str = {"?","#"};
        for (int i = 0; i < lines; i++) {
          System.out.println(str[i % str.length].repeat(2 * i + 1));
        }
    }
}
