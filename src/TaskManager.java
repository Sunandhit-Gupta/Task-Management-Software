import java.util.ArrayList;
import java.util.Comparator;

// TaskManager class to handle task operations
public class TaskManager {
    private ArrayList<Task> tasks;

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a new task
    public void addTask(int taskID, String taskName, String dueDate, String priority) {
        // Check if taskID already exists
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                System.out.println("Error: TaskID " + taskID + " already exists.");
                return;
            }
        }
        // Validate priority
        if (!priority.equalsIgnoreCase("High") && !priority.equalsIgnoreCase("Medium") && !priority.equalsIgnoreCase("Low")) {
            System.out.println("Error: Invalid priority. Use High, Medium, or Low.");
            return;
        }
        // Validate due date format (simple check for YYYY-MM-DD)
        if (!dueDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Error: Invalid date format. Use YYYY-MM-DD.");
            return;
        }
        tasks.add(new Task(taskID, taskName, dueDate, priority));
        System.out.println("Task added successfully!");
    }

    // View all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nAll Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // View tasks sorted by priority
    public void viewTasksByPriority() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((t1, t2) -> {
            int p1 = getPriorityValue(t1.getPriority());
            int p2 = getPriorityValue(t2.getPriority());
            return Integer.compare(p1, p2); // High (1) < Medium (2) < Low (3)
        });
        System.out.println("\nTasks Sorted by Priority:");
        for (Task task : sortedTasks) {
            System.out.println(task);
        }
    }

    // View tasks sorted by due date
    public void viewTasksByDueDate() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparing(Task::getDueDate));
        System.out.println("\nTasks Sorted by Due Date:");
        for (Task task : sortedTasks) {
            System.out.println(task);
        }
    }

    // Helper method to assign numeric value to priority
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "high": return 1;
            case "medium": return 2;
            case "low": return 3;
            default: return 4; // Invalid priority
        }
    }

    // Update a task
    public void updateTask(int taskID, String taskName, String dueDate, String priority) {
        Task task = findTaskByID(taskID);
        if (task == null) {
            System.out.println("Error: TaskID " + taskID + " not found.");
            return;
        }
        // Update fields if provided
        if (taskName != null && !taskName.isEmpty()) {
            task.setTaskName(taskName);
        }
        if (dueDate != null && dueDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            task.setDueDate(dueDate);
        } else if (dueDate != null) {
            System.out.println("Error: Invalid date format. Use YYYY-MM-DD. Date not updated.");
        }
        if (priority != null && (priority.equalsIgnoreCase("High") || priority.equalsIgnoreCase("Medium") || priority.equalsIgnoreCase("Low"))) {
            task.setPriority(priority);
        } else if (priority != null) {
            System.out.println("Error: Invalid priority. Use High, Medium, or Low. Priority not updated.");
        }
        System.out.println("Task updated successfully!");
    }

    // Delete a task
    public void deleteTask(int taskID) {
        Task task = findTaskByID(taskID);
        if (task == null) {
            System.out.println("Error: TaskID " + taskID + " not found.");
            return;
        }
        tasks.remove(task);
        System.out.println("Task deleted successfully!");
    }

    // Helper method to find task by ID
    private Task findTaskByID(int taskID) {
        for (Task task : tasks) {
            if (task.getTaskID() == taskID) {
                return task;
            }
        }
        return null;
    }
}