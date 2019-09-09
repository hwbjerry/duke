//A-MoorOOP
//A-JavaDoc

import java.util.ArrayList;

/**
 * TaskList class that contain the task list and includes
 * operation such as add/delete task in the list.
 */
public class TaskList {
    public ArrayList<Task> taskList;

    /**
     * Constructor to initialize an arrayList called temp.
     *
     * @param temp an arrList containing all the tasks.
     */
    public TaskList(ArrayList<Task> temp) {
        this.taskList = temp;
    }

    /**
     * Adds the entered task into the taskList.
     *
     * @param temp an taskList containing all the tasks.
     */
    public void addTask(Task temp) {
        taskList.add(temp);
    }

    /**
     * Removes the entered task from the taskList.
     *
     * @param index index of the element in the taskList that have to be removed.
     */
    public void removeTask(int index) {
        taskList.remove(index);
    }

    //flags item as completed (done)

    /**
     * Updates boolean of flag at particular index of taskList
     * @param index index of the element in the taskList
     */
    public void markCompleted(int index) {
        taskList.get(index).updateFlag();
    }

    /**
     * Generates the size of the taskList
     *
     * @return size of the taskList
     */
    public int getSize(){
        return taskList.size();
    }

    /**
     * Generates string in the desired output format
     *
     * @param index index of the element in the taskList
     * @return desired output format of all details
     */
    public String getAllDescription(int index) {
        return taskList.get(index).getStatusIcon();
    }

    /**
     * Returns a copy of the element found in index of the arrayList
     *
     * @param index index of the element in the taskList
     * @return taskList found in arrayList of Task at index given
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }
}
