//A-Inheritance


public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.type = "type";
    }

    @Override
    public String getStatusIcon() {
        return  "[E][" + super.getStatusIcon() + "] " + getDescription();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "(at: " + at + ")";
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getWhen() {
        return at;
    }
}
