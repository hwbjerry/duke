import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Duke {

    static ArrayList<Task> taskList = new ArrayList<Task>();


    public static void main(String[] args) throws IOException{
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);


        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);
        String userInput;

        FileWriter openFile = null;

        try {
            openFile = new FileWriter("output.txt");


            while (true) {
                try {
                    userInput = input.nextLine();

                    if (userInput.equals("list")) {
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + ". " + taskList.get(i).getStatusIcon());
                        }
                    } else if (userInput.equals("bye")) {
                        System.out.println("Bye. Hope to see you again soon!");
                        break;
                    }
                    else {
                        if (userInput.startsWith("todo")) {
                            try {
                                String taskOut = userInput.replaceFirst("todo", "");//todo| |read book spilt to three parts
                                taskOut = taskOut.trim();
                                if (taskOut.isEmpty()) {
                                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                                }
                                taskList.add(new Todo(taskOut));
                                System.out.println("Got it. I've added this task:");
                                System.out.println("  " + taskList.get(taskList.size() - 1).getStatusIcon());
                                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                                openFile.write("T | 0 | " +  taskOut + "\n");

                            } catch (DukeException e) {
                                //catch exception
                                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                                System.out.println("Please enter another task!");
                                continue;
                            }
                        } else if (userInput.startsWith("deadline")) {
                            try {
                                String taskOut = userInput.replaceFirst("deadline", "");
                                taskOut = taskOut.trim();
                                if (taskOut.isEmpty()) {
                                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                                }
                                String[] by = taskOut.split(" /by ", 2);//3. by|sunday
                                taskList.add(new Deadline(by[0], by[1]));
                                System.out.println("Got it. I've added this task:");
                                System.out.println("  " + taskList.get(taskList.size() - 1).getStatusIcon());
                                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                                openFile.write("D | 0 | " + by[0] + " | " + by[1] + "\n");
                            } catch (DukeException exception) {
                                System.out.println("Please enter another task! in the form: deadline 'description' /by 'due period'");
                                continue;
                            }
                        } else if (userInput.startsWith("event")) {
                            try {
                                String taskOut = userInput.replaceFirst("event", "");
                                taskOut = taskOut.trim();
                                if (taskOut.isEmpty()) {
                                    throw new DukeException("Please enter another task! In the form: event 'description' /at 'due period'");
                                }
                                String[] at = taskOut.split(" /at ", 2);
                                taskList.add(new Event(at[0], at[1]));
                                System.out.println("Got it. I've added this task:");
                                System.out.println("  " + taskList.get(taskList.size() - 1).getStatusIcon());
                                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                                openFile.write("E | 0 | " + at[0] + " | " + at[1] + "\n");
                            } catch (DukeException exception) {
                                System.out.println("Please enter another task! In the form: event 'description' /at 'due period'");
                                continue;
                            }
                        } else if (userInput.startsWith("done")) {
                            String[] split = userInput.split(" ", 2);
                            int index = Integer.parseInt(split[1]) - 1;
                            if (index < 0 || index >= taskList.size()) {
                                System.out.println("Invalid number!");
                            }
                            else {
                                taskList.get(index).updateFlag();
                                System.out.println("  " + taskList.get(index).getStatusIcon());

                                //Write to file
                                openFile.close();
                                openFile = new FileWriter("output.txt");
                                for(int i = 0; i < taskList.size(); i++){
                                    openFile.write(taskList.get(i).getType()+ " | " + taskList.get(i).isDone + " | " + taskList.get(i).description + " | " + taskList.get(i).getWhen() + "\n");
                                }
                            }
                        }
                        else if(userInput.startsWith("delete")){
                            String[] split = userInput.split(" ", 2);
                            int index = Integer.parseInt(split[1]) - 1;
                            if (index < 0 || index >= taskList.size()){
                                System.out.println("Invalid number!");
                            }
                            else{

                                System.out.println("Noted. I've removed this task: \n" +
                                        "       " + taskList.get(index).getStatusIcon() + taskList.get(index).getWhen() + "\n" +
                                        "     Now you have " + (taskList.size() - 1) +" tasks in the list.");
                                taskList.remove(index);
                                //Write to file
                                openFile.close();
                                openFile = new FileWriter("output.txt");
                                for(int i = 0; i < taskList.size(); i++){
                                    openFile.write(taskList.get(i).getType()+ " | " + taskList.get(i).isDone + " | " + taskList.get(i).description + " | " + taskList.get(i).getWhen() + "\n");
                                }
                            }
                        }else {
                            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        }
                    }
                } catch (DukeException exception) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    // continue;
                }
            }

        }finally {
            openFile.close();
        }

    }








}
