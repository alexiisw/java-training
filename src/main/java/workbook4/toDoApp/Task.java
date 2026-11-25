package workbook4.toDoApp;

public class Task {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        // TODO: initialize the fields (a new task is not completed)
        this.id = id;
        this.description = description;
        this.completed = false; // starts all task as not completed
    }
    public void markCompleted() {
        // TODO
        completed = true;
    }
    public boolean isCompleted() {
        // TODO
        return completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override // tells Java that we intend to replace a method that already exists in the parent Object class
    public String toString() {
        // TODO: return "1. [ ] Buy milk", or "2. [x] Write report" when completed
        return id + ". [" + (completed ? "x" : " ") + "] " + description;
        // (completed ? "x" : " ") is a ternary operator; same as (If completed is true, use "x") its like a compact if/else
        // : " " - is telling it to fill with a space if not completed
    }
}
