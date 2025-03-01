//A-Classes

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String when;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = "type";
        this.when = "when";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription(){
        return description;
    }

    public void updateFlag(){
        isDone = true;
    }

    public void updateDescription(String userInput){
        description = userInput;
    }

    public String getType(){
        return type;
    }

    public String getWhen(){
        return when;
    }

}
