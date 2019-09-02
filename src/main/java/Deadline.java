public class Deadline extends Task {

    protected String by;
    protected String type;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.type = "type";
    }

    public String getBy() {
        return by;
    }

    @Override
    public String getStatusIcon() {
        return "[D][" + super.getStatusIcon() + "] " + getDescription();

    }

    @Override
    public String getDescription() {
        return super.getDescription() + "(by: " + by + ")";
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String getWhen() {
        return by;
    }
}
