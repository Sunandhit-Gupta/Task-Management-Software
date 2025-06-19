// Task class to represent a task with TaskID, TaskName, DueDate, and Priority
public class Task {
    private int taskID;
    private String taskName;
    private String dueDate; // Format: YYYY-MM-DD
    private String priority; // High, Medium, Low

    // Constructor
    public Task(int taskID, String taskName, String dueDate, String priority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Getters and Setters
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // ToString for displaying task details
    @Override
    public String toString() {
        return "TaskID: " + taskID + ", Name: " + taskName + ", Due Date: " + dueDate + ", Priority: " + priority;
    }
}