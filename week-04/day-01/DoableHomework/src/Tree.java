public class Tree {
    private String type;
    private String leafcolor;
    private String sex;
    private int age;

    public void setType(String t) {
        this.type = t;
    }
    public String getType(String t) {
        return this.type;
    }

    public void setLeafcolor(String color){
        this.leafcolor = color;
    }
    public String getLeafcolor(String t) {
        return this.leafcolor;
    }

    public void setSex(String s) {
        this.sex = s;
    }
    public String getSex(String s){
        return this.sex;
    }

    public void setAge(int a) {
        this.age = a;
    }
    public int getAge(int a) {
        return this.age;
    }
}
