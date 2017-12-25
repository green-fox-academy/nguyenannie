public class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(){
        name = "Jane Doe";
        age = 30;
        gender = "Female";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        if(gender.equals("Female") || gender.equals("female")) {
            this.gender = "Female";
        } else if(gender.equals("Male") || gender.equals("male")) {
            this.gender = "Male";
        } else {
            System.out.println("Invalid input");
        }
    }

    public String getGender() {
        return this.gender;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + " ,a " + age + " year old " + gender + ".");
    }

    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }


}

