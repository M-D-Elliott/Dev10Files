package lesson;

public class Dog {
    String name;
    String breed;
    int age;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    
    public Dog(String name, String breed, String age) {
        this.name = name;
        this.breed = breed;
        this.age = Integer.parseInt(age);
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }
    
    
}
