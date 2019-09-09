//A-Inheritance
//A-JavaDoc

/**
 * Todo class that extends from Task class. Contains the description and type of the task.
 */
public class Todo extends Task{

    /**
     * Constructor to initialize the description
     *
     * @param description descriptions the task
     */
    public Todo(String description){
        super(description);
        this.type = "T";
    }

    /**
     * Returns the statusIcon
     *
     * @return a String to states the statusIcon
     */
    @Override
    public String getStatusIcon() {
        return "[T][" + super.getStatusIcon() + "] " + description;
    }

    /**
     * Returns the task type that the user inputs
     *
     * @return a String that is the task type that is entered by the user
     */
    @Override
    public String getType() {
        return type;
    }
}
