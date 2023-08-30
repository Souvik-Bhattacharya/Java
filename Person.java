class PersonClass {
    String name;
    String address;
    int age;
    String gender;
    String occupation;
    PersonClass(String name, String address, int age, String gender, String occupation){
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }
    void showInfo(){
        System.out.println(((gender == "male") ? "Mr. " : "Ms. ") + name + " of age " + age + " who lives in " + address + " is " + occupation);
    }
}

public class Person {
    public static void main(String args[]){
        PersonClass person1 = new PersonClass("Souvik", "7/MMP lane", 20, "male", "student");
        person1.showInfo();
    }
}