package workbook4.toDoApp;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp { // go over code
    private ArrayList <Task> tasks;
    private Scanner scanner;
    private int nextId;

    public TodoApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        nextId = 1;
    }

    public void run() {
        System.out.println("=== Welcome to Your To-Do App ===");

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: markTaskComplete(); break;
                case 4: removeTask(); break;
                case 5:
                    System.out.println("Thanks for using To-Do App!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- To-Do Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task Complete");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Choose option: ");
    }

    private int getChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }

    private void addTask() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        if (!description.trim().isEmpty()) {
            Task task = new Task(nextId++, description);
            tasks.add(task);
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task description cannot be empty.");
        }
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Add some tasks first!");
            return;
        }

        System.out.println("\n=== Your Tasks ===");
        for (Task task : tasks) {
            System.out.println(task);
        }

        // Show statistics
        int completed = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) completed++;
        }
        System.out.println("\nTotal: " + tasks.size() + " | Completed: " + completed + " | Remaining: " + (tasks.size() - completed));
    }

    private void markTaskComplete() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task ID to mark complete: ");
        int id = getChoice();

        Task task = findTaskById(id);
        if (task != null) {
            task.markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private void removeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task ID to remove: ");
        int id = getChoice();

        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.run();
    }
}

    // example without scanner
//    public static void main(String[] args) {
//        // Warm-up: this main method tests your Task class. Do not change it.
//        ArrayList<Task> tasks = new ArrayList<>();
//        tasks.add(new Task(1, "Buy milk"));
//        tasks.add(new Task(2, "Write report"));
//        tasks.add(new Task(3, "Call the dentist"));
//        tasks.get(1).markCompleted();
//        for (Task task : tasks) {
//            System.out.println(task);
//        }
//        System.out.println("Open tasks: " + countOpen(tasks));
//    }
//
//    static int countOpen(ArrayList<Task> tasks) {
//        // TODO: return how many tasks are not completed yet
//        int count = 0; // 0 because no task were completed yet
//
//        for (Task task : tasks){ // goes through task list one task at a time
//            if (!task.isCompleted()) { // ask if the task is not completed
//                count++; // increases the count by one if task is not completed
//            }
//        }
//            return count; // returns final count
//    }
//}


