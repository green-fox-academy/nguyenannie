public class ToDo implements Comparable<ToDo>{
    private String description;
    private boolean completed;

    public ToDo(String name) {
        this.description = name;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }

    @Override
    public int compareTo(ToDo compareToDo) {
        boolean completeStatus = compareToDo.completed;
        String descriptionStatus = compareToDo.description;
        if(this.completed && !completeStatus) {
            return -1;
        } else if (!this.completed && completeStatus) {
            return 1;
        } else {
            return this.description.compareTo(descriptionStatus);
        }
    }
}
