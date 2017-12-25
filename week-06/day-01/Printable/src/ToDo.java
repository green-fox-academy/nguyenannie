public class ToDo implements Printable {
    private String description;
    private boolean completed;

    ToDo(String name) {
        this.description = name;
    }

    void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }

    @Override
    public void printAllField() {
        System.out.println();
        System.out.print(toString());
    }
}

