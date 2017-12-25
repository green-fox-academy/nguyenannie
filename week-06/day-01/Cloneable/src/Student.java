class Student extends Person implements Cloneable{

    private String previousOrganization;
    private int skippedDays;

    Student(String name, int age, String gender, String previousOrganization) throws CloneNotSupportedException {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student() {
        name = "Jane Doe";
        age = 30;
        gender = "Female";
        previousOrganization = "The School of Life";
        skippedDays = 0;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + " ,a " + age + " year old " + gender + " from "
                + previousOrganization + " who skipped " + skippedDays + " days from the courses already!");
    }

    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }

    @Override
    public String toString() {
        return "Hi, I'm " + name + " ,a " + age + " year old " + gender + " from "
                + previousOrganization + " who skipped " + skippedDays + " days from the courses already!";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student john = new Student("John Doe", 20, "male", "BME");
        Student johnTheClone = (Student) john.clone();

        System.out.println(johnTheClone.toString());
    }
}
