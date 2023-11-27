package person;

public class Person {
    String name;
    String address;
    int age;
    String gender;
    String occupation;

    Person(String name, String address, int age, String gender, String occupation){
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    void showBioData(){
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("Occupation: "+occupation);
    }

    public static void main(String args[]){
        Person person1 = new Person("Souvik", "Bhatpara", 20, "Male", "Student");
        person1.showBioData();
    }
}