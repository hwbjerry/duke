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

        level4();
    }


    static void level4(){
        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);
        String userInput;

        ArrayList<Task> taskList = new ArrayList<Task>();

        while(true){
            userInput = input.nextLine();

            if(userInput.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < taskList.size(); i++)
                    System.out.println((i+1) + ". " + taskList.get(i).getStatusIcon());
            }
            else if(userInput.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else{
                String[] split = userInput.split(" ", 2);//eg 1. deadline|return book /by Sunday

                if(split[0].equals("todo")){
                    taskList.add(new Todo(split[1]));
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskList.get(taskList.size()-1).getStatusIcon());
                    System.out.println("Now you have " + taskList.size()+ " tasks in the list.");
                }
                else if(split[0].equals("deadline")){
                    String[] taskDescription = split[1].split("/", 2); //2. return book |by Sunday
                    String[] by = taskDescription[1].split(" ", 2);//3. by|sunday
                    taskList.add(new Deadline(taskDescription[0], by[1]));
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskList.get(taskList.size()-1).getStatusIcon());
                    System.out.println("Now you have " + taskList.size()+ " tasks in the list.");
                }
                else if(split[0].equals("event")){
                    String[] taskDescription = split[1].split("/", 2); //eg read book
                    String[] at = taskDescription[1].split(" ", 2);
                    taskList.add(new Event(taskDescription[0], at[1]));
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskList.get(taskList.size()-1).getStatusIcon());
                    System.out.println("Now you have " + taskList.size()+ " tasks in the list.");
                }
                else if(split[0].equals("done")){
                    taskList.get(Integer.parseInt(split[1]) - 1).updateFlag();
                    System.out.println("  " + taskList.get(Integer.parseInt(split[1]) - 1).getStatusIcon());
                }
            }

        }
    }


}
