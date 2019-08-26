public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String getStatusIcon() {
        return  "[E][" + super.getStatusIcon() + "] " + getDescription();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "(at: " + at + ")";
    }
}
