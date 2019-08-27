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

        level3A_Classes();
    }


    static void level3A_Classes(){

        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);
        String userInput;

        ArrayList<Task> taskList = new ArrayList<Task>();

        while(true){
            userInput = input.nextLine();

            if(userInput.equals("list")){
                for(int i = 0; i < taskList.size(); i++){
                    System.out.println((i+1) + ".[" + taskList.get(i).getStatusIcon()+ "] " + taskList.get(i).getDescription());
                }
            }
            else if(userInput.equals("bye")){
                break;
            }
            else{
                String[] temp = userInput.split(" ", 2);
                if(temp[0].equals("done")){
                    int index = Integer.parseInt(temp[1]) -1;
                    taskList.get(index).updateFlag();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + taskList.get(index).getStatusIcon()+ "] " + taskList.get(index).getDescription());
                }
                else{
                    Task temporary = new Task(userInput);
                    taskList.add(temporary);
                    System.out.println("added: " + userInput);
                }
            }
        }

        System.out.println("Bye, Hope to see you again soon!");

    }


}
