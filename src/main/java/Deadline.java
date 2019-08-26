public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
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
}
