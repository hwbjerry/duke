//A-MoorOOP

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> temp) {
        this.taskList = temp;
    }

    //adds new item to array list
    public void addTask(Task temp) {
        taskList.add(temp);
    }

    //remove selected item
    public void removeTask(int index) {
        taskList.remove(index);
    }

    //flags item as completed (done)
    public void markCompleted(int index) {
        taskList.get(index).updateFlag();
    }

    public int getSize(){
        return taskList.size();
    }

    //gets desired output format of all details
    public String getAllDescription(int index) {
        return taskList.get(index).getStatusIcon();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
}
