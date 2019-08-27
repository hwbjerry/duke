import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class Duke {


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        level1();
    }



    static void level1(){
        System.out.println("What can I do for you?");

        Scanner input =new Scanner(System.in);

        String userInput = input.nextLine();

        while(!userInput.equals("bye")){
            System.out.println("   " + userInput);
            userInput = input.nextLine();
        }

        System.out.println("Bye, Hope to see you again soon!");
    }

}
