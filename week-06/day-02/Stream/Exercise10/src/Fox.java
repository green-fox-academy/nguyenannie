public class Fox {
    private String name;
    private String color;
    private String type;

    Fox(String name, String type, String color) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Fox's name: " + getName() + ", fox's type: " + getType() + " and fox's color: " + getColor();
    }
}
