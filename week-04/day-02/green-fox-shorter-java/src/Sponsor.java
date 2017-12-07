public class Sponsor extends Person {
    String name;
    int age;
    String gender;
    String company;
    int hiredStudents;

    public Sponsor(String name, int age, String gender, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.gender = gender;
    }

    public Sponsor(){
        name = "Jane Doe";
        age = 30;
        gender = "Female";
        company = "Google";
        hiredStudents = 0;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + " ,a " + age + " year old " + gender + " who presents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void hire(){
        hiredStudents += 1;
    }
    public void getGoal(){
        System.out.println("Hire brilliant junior software developers.");
    }
}
