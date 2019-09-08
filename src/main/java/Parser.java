//A-MoorOOP

public class Parser {
    //protected String userInput;
    private TaskList taskList; //= new TaskList();
    private Ui ui; //= new Ui();

    public Parser(Ui ui, TaskList taskList) {
        //this.userInput = userInput;
        //decode(userInput);
        this.taskList = taskList;
        this.ui = ui;
    }

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
                    taskList.addTask(new Deadline(by[0], by[1]));
                    ui.addedTaskMessage(taskList.getTask(taskList.getSize() - 1).getStatusIcon(), taskList.getSize());
                } catch (DukeException exception) {
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
                    taskList.addTask(new Event(at[0], at[1]));
                    ui.addedTaskMessage(taskList.getTask(taskList.getSize() - 1).getStatusIcon(), taskList.getSize());
                    //                System.out.println("Got it. I've added this task:");
                    //                System.out.println("  " + taskList.getTask(taskList.getSize() - 1).getStatusIcon());
                    //                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    //                openFile.write("E | 0 | " + at[0] + " | " + at[1] + "\n");
                } catch (DukeException exception) {
                    System.out.println("Please enter another task! In the form: event 'description' /at 'due period'");
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
                        throw new DukeException("Please enter another task! In the form: event 'description' /at 'due period'");
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
