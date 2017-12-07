public class Person {
    String name;
    int age;
    private String gender;

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

    public void setGender(String gendera) {
        if(gendera.equals("Female") || gendera.equals("female")) {
            this.gender = "Female";
        } else if(gendera.equals("Male") || gendera.equals("male")) {
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
