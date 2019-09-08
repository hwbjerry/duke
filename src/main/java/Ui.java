import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    protected Scanner scan = new Scanner(System.in);

    public String scanLine() {
        return scan.nextLine();
    }

    public void showWelcomeDukeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public void showLine() {
        System.out.println("\t____________________________________________________________");
    }

    public void sayHello() {
        showLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        showLine();
    }
    public void sayBye() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

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
    public void completeMessage(String task) {
        showLine();
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t\t" + task);
        showLine();
    }
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
    public void listFindDetails(TaskList taskList, int size){
        showLine();
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for(int i = 0; i < taskList.getSize(); i++){
            System.out.println(count++ + ". " + taskList.getTask(i).getStatusIcon());

        }
    }
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
    public void showLoadingError(DukeException exception) {
        showLine();
        System.out.println("\t" + exception.getMessage());
        showLine();
    }
}
