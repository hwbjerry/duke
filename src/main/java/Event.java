//A-Inheritance
//A-JavaDoc

/**
 * Event class that extends from Task class. Contains the description, date and time and type of the task.
 */
public class Event extends Task{
    protected String at;
    /**
     * Constructor to initialize the description and at
     *
     * @param description descriptions the task
     * @param at at reflects the due time
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.type = "E";
    }

    /**
     * Returns the statusIcon
     *
     * @return a String to states the statusIcon
     */
    @Override
    public String getStatusIcon() {
        return  "[E][" + super.getStatusIcon() + "] " + getDescription();
    }

    /**
    * Returns the task that the user inputs in the format expected by the UI
     *
    * @return a String that is the task that is entered by the user
    */
    @Override
    public String getDescription() {
        return super.getDescription() +  "(at: " + at + ")";
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
        return at;
    }
}
