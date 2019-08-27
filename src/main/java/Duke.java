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

        level2ArrayList();
    }


    static void level2ArrayList(){
        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);

        String userInput;
        ArrayList list = new ArrayList();

        while(true){
            userInput = input.nextLine();
            if(userInput.equals("list")){
                for(int i = 0; i < list.size(); i++){
                    System.out.println((i+1) + "." + list.get(i));
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else {
                list.add(userInput);
                System.out.println("added: " + userInput);
            }
        }

        System.out.println("Bye, Hope to see you again soon!");
    }

}
