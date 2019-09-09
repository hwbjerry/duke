//A-Inheritance

/**
 * Deadline class that extends from Task class. Contains the description, date and time and type of the task.
 */
public class Deadline extends Task {

    protected String by;
    protected String type;

    /**
     * Constructor to initialize the description and by
     *
     * @param description describes the task
     * @param by at reflects the due time
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.type = "D";
    }
    /**
     * Returns the statusIcon
     *
     * @return a String to states the statusIcon
     */
    @Override
    public String getStatusIcon() {
        return "[D][" + super.getStatusIcon() + "] " + getDescription();
    }

    /**
     * Returns the task that the user inputs in the format expected by the UI
     *
     * @return a String that is the task that is entered by the user
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "(by: " + by + ")";
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

    /**
     * Returns the time that the user inputs
     *
     * @return a String that is the time that is entered by the user
     */
    @Override
    public String getWhen() {
        return by;
    }
}
