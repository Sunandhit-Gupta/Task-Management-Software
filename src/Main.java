import java.util.Scanner;

// Main class to provide console-based user interface
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        // Add Task
                        System.out.print("Enter Task ID: ");
                        int taskID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Task Name: ");
                        String taskName = scanner.nextLine();
                        System.out.print("Enter Due Date (YYYY-MM-DD): ");
                        String dueDate = scanner.nextLine();
                        System.out.print("Enter Priority (High/Medium/Low): ");
                        String priority = scanner.nextLine();
                        taskManager.addTask(taskID, taskName, dueDate, priority);
                        break;

                    case "2":
                        // View Tasks
                        System.out.println("1. View All Tasks");
                        System.out.println("2. View Tasks Sorted by Priority");
                        System.out.println("3. View Tasks Sorted by Due Date");
                        System.out.print("Enter your choice: ");
                        String viewChoice = scanner.nextLine();
                        switch (viewChoice) {
                            case "1":
                                taskManager.viewTasks();
                                break;
                            case "2":
                                taskManager.viewTasksByPriority();
                                break;
                            case "3":
                                taskManager.viewTasksByDueDate();
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case "3":
                        // Update Task
                        System.out.print("Enter Task ID to update: ");
                        int updateID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new Task Name (or press Enter to skip): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new Due Date (YYYY-MM-DD, or press Enter to skip): ");
                        String newDueDate = scanner.nextLine();
                        System.out.print("Enter new Priority (High/Medium/Low, or press Enter to skip): ");
                        String newPriority = scanner.nextLine();
                        taskManager.updateTask(updateID, newName, newDueDate, newPriority);
                        break;

                    case "4":
                        // Delete Task
                        System.out.print("Enter Task ID to delete: ");
                        int deleteID = Integer.parseInt(scanner.nextLine());
                        taskManager.deleteTask(deleteID);
                        break;

                    case "5":
                        // Exit
                        System.out.println("Exiting Task Management System. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number for Task ID.");
            } catch (Exception e) {
                System.out.println("Error: An unexpected error occurred. Please try again.");
            }
            System.out.println();
        }
    }

    // Display the menu
    private static void displayMenu() {
        System.out.println("Personal Task Management System");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
    }
}