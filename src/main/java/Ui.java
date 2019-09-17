//A-MoorOOP
//A-JavaDoc

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ui class is one that deals with the interactions with the user.
 * For instance printing out the welcome, bye, hello, add task,
 * completed task and delete task message.
 */
public class Ui {


    protected Scanner scan = new Scanner(System.in);

    /**
     * Scans a line of input from the user
     * @return the user input
     */
    public String scanLine() {
        return scan.nextLine();
    }

    /**
     * Print out the Duke welcome message when the program starts.
     */
    public void showWelcomeDukeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prints out a line of _.
     */
    public void showLine() {
        System.out.println("\t____________________________________________________________");
    }

    /**
     * Prints out Hello message.
     */
    public void sayHello() {
        showLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        showLine();
    }
    /**
     * Prints out the Bye message.
     */
    public void sayBye() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    /**
     * Prints out the addTask message and informs the user the number of list in the array.
     *
     * @param task the task that have to be added to the list.
     * @param size the number of elements in the list.
     */
    public void addedTaskMessage(String task, int size) {
        showLine();
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t\t" + task);
//        if (size > 1) {
            System.out.println("\tNow you have " + size + " tasks in your list.");
//        }
//        else {
//            System.out.println("\tNow you have " + size + " task in the list.");
//        }
        showLine();
    }

    /**
     * Prints out the completedTask message.
     *
     * @param task the task that have to be added to the list.
     */
    public void completeMessage(String task) {
        showLine();
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t\t" + task);
        showLine();
    }

    /**
     * Prints out the deleted message and informs the user the number of list in the array.
     *
     * @param task the task that have to be added to the list.
     * @param size the number of elements in the list.
     */
    public void deleteMessage(Task task, int size) {
        showLine();
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t\t" + task.getStatusIcon());
//        if (size > 1) {
        System.out.println("\tNow you have " + size + " tasks in your list.");
//        } else {
//            System.out.println("\tNow you have " + size + " task in the list.");
//        }
        showLine();
    }

    /**
     * Prints out all tasks.
     *
     * @param taskList contains the tasks
     * @param size size of the taskList
     */
    public void listFindDetails(TaskList taskList, int size){
        showLine();
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for(int i = 0; i < taskList.getSize(); i++){
            System.out.println(count++ + ". " + taskList.getTask(i).getStatusIcon());

        }
    }

    /**
     * Prints out the task that contains the keyword.
     *
     * @param taskList contains the tasks
     * @param keyword the special word to be search in task
     * @param size size of the taskList
     */
    public void listFindDetailsWithKeyword(TaskList taskList,String keyword, int size){
        showLine();
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for(int i = 0; i < taskList.getSize(); i++){
            if(taskList.getTask(i).getDescription().contains(keyword)){
                System.out.println(count++ + ". " + taskList.getTask(i).getStatusIcon());
            }
        }
    }

    /**
     * Prints out the exception message.
     *
     * @param exception an error when the user inputs the wrong input format.
     */
    public void showLoadingError(DukeException exception) {
        showLine();
        System.out.println("\t" + exception.getMessage());
        showLine();
    }
}
