//A-MoorOOP
//A-JavaDoc

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parser class that deals with making sense of the  user's input
 */
public class Parser {
    private TaskList taskList;
    private Ui ui;

    /**
     * Constructor to initialize the ui and taskList
     * @param ui ui Class
     * @param taskList taskList class
     */
    public Parser(Ui ui, TaskList taskList) {
        this.taskList = taskList;
        this.ui = ui;
    }

    /**
     * This method of parse will run the program base on the user's command (ie add to
     * list when it is deadline, events... while done will mark the task as done and
     * delete will remove the task from the list.
     *
     * @param userInput the user's input.
     * @throws DukeException If user's input does not have description and when the
     * user enters invalid inputs.
     */
    public void decode(String userInput) throws DukeException {

        while(!userInput.equals("bye")) {
         try{
            userInput = ui.scanLine();
            if (userInput.startsWith("todo")) {
                try {
                    String taskOut = userInput.replaceFirst("todo", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");
                    }
                    //Todo todo = new Todo(taskOut);
                    taskList.addTask(new Todo(taskOut));
                    ui.addedTaskMessage(taskList.getTask(taskList.getSize() - 1).getStatusIcon(), taskList.getSize());


                } catch (DukeException e) {
                    //catch exception
                    System.out.println("\u2639 OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("Please enter another task!");
                }
            } else if (userInput.startsWith("deadline")) {
                try {
                    String taskOut = userInput.replaceFirst("deadline", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");
                    }
                    String[] by = taskOut.split(" /by ", 2);//3. by|sunday

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    Date date = format.parse(by[1].trim());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mma");
                    by[1] = dateFormat.format(date);

                    taskList.addTask(new Deadline(by[0], by[1]));
                    ui.addedTaskMessage(taskList.getTask(taskList.getSize() - 1).getStatusIcon(), taskList.getSize());
                } catch (ParseException | DukeException exception) {
                    System.out.println("Please enter another task! in the form: deadline 'description' /by 'due period'");
                }
            } else if (userInput.startsWith("event")) {
                try {
                    String taskOut = userInput.replaceFirst("event", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        throw new DukeException("Please enter another task! In the form: event 'description' /at 'due period'");
                    }
                    String[] at = taskOut.split(" /at ", 2);

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    Date date = format.parse(at[1].trim());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mma");
                    at[1] = dateFormat.format(date);

                    taskList.addTask(new Event(at[0], at[1]));
                    ui.addedTaskMessage(taskList.getTask(taskList.getSize() - 1).getStatusIcon(), taskList.getSize());
                    //                System.out.println("Got it. I've added this task:");
                    //                System.out.println("  " + taskList.getTask(taskList.getSize() - 1).getStatusIcon());
                    //                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    //                openFile.write("E | 0 | " + at[0] + " | " + at[1] + "\n");
                } catch (ParseException | DukeException exception) {
                    System.out.println("Please enter another task! In the form: event 'description' /at 'dd/MM/yyyy HHmm'");
                }
            } else if (userInput.startsWith("done")) {
                String[] split = userInput.split(" ", 2);
                int index = Integer.parseInt(split[1]) - 1;
                if (index < 0 || index >= taskList.getSize()) {
                    System.out.println("Invalid number!");
                } else {
                    taskList.markCompleted(index);
                    // System.out.println("  " + taskList.getAllDescription());
                    ui.completeMessage(taskList.getTask(index).getStatusIcon());
                    //                //Write to file
                    //                openFile.close();
                    //                openFile = new FileWriter("output.txt");
                    //                for(int i = 0; i < taskList.size(); i++){
                    //                    openFile.write(taskList.get(i).getType()+ " | " + taskList.get(i).isDone + " | " + taskList.get(i).description + " | " + taskList.get(i).getWhen() + "\n");
                    //                }
                }
            } else if (userInput.startsWith("find")) {
                try {
                    String taskOut = userInput.replaceFirst("find", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        throw new DukeException("Please enter another task! In the form: event 'description' /at 'dd/MM/yyyy HHmm'");
                    }
                    ui.listFindDetailsWithKeyword(taskList, taskOut, taskList.getSize());
                } catch (DukeException exception) {
                    System.out.println("Please find in format. find 'keyword'");
                }
            } else if (userInput.startsWith("list")) {
                try {
                    String taskOut = userInput.replaceFirst("list", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        ui.listFindDetails(taskList, taskList.getSize());
                    } else {
                        System.out.println("Please find in format. find 'keyword'");
                        continue;
                    }
                } catch (DukeException exception) {
                    throw new DukeException("Please find in format. find 'keyword'");

                }
            } else if (userInput.startsWith("delete")) {
                //next time (branch-level-6)
                try{
                    String taskOut = userInput.replaceFirst("delete", "");
                    taskOut = taskOut.trim();
                    if (taskOut.isEmpty()) {
                        System.out.println("Please delete in format. find 'number'");
                        continue;
                    } else {
                        int index = Integer.parseInt(taskOut) - 1;
                        if (index < 0 || index >= taskList.getSize()) {
                            System.out.println("Invalid number!");
                        } else {
                            ui.deleteMessage(taskList.getTask(index), (taskList.getSize() - 1));
                            taskList.removeTask(index);
                        }
                        //ui.listFindDetails(taskList, taskList.getSize());
                    }

                }catch (DukeException exception){
                    throw new DukeException("Please delete in format. delete 'keyword'");
                }
            } else if (userInput.startsWith("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else {
                System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }catch (DukeException exception) {
                    System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                    // continue;
                }
        }
    }

}
