public class Student {
    String studentName;
    int studentAge;
    private String studentGender;
    String previousOrganization;
    int skippedDays;

    public Student(String name, int age, String gender, String previousOrganization){
        this.studentName = name;
        this.studentAge = age;
        this.studentGender = gender;
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student(){
        studentName = "Jane Doe";
        studentAge = 30;
        studentGender = "Female";
        previousOrganization = "The School of Life";
        skippedDays = 0;
    }

    public void setGender(String gendera) {
        if(gendera.equals("Female") || gendera.equals("female")) {
            this.studentGender = "Female";
        } else if(gendera.equals("Male") || gendera.equals("male")) {
            this.studentGender = "Male";
        } else {
            System.out.println("Invalid input");
        }
    }

    public String getGender() {
        return this.studentGender;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + studentName + " ,a " + studentAge + " year old " + studentGender + " from " + previousOrganization + " who skipped " + skippedDays + " days from the courses already!");
    }

    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }

}
