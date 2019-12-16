package com.sg.javamilestone3.streams;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Person {
   
    private String name;
    private int age;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }   
    
    // compared to Predicate<T>
    public boolean test(Person person) {
        return person.getAge() >= 18;
    }
    
    // with syntactic shortcuts:
    Predicate<Person> oldEnoughToVote = p -> p.getAge() >= 18;
    // with more than one method in declaration:
    
    // compared to Consumer<T>
    public void accept(Person person) {
    System.out.println(person.getName() 
        + " is " 
        + person.getAge() 
        + " years old.");
    }
    
    // consumer pattern reduced: (consumer used void return type only for accept.)
    Consumer<Person> howOld = p -> System.out.println(p.getName() + " is " + p.getAge() + " years old.");
    
    // compared to ToIntFunction<T>:
//    public int applyAsInt(Person p) {
//        return p.getAge();
//    }
    // to int reduced further using :: syntactic shortcut
    ToIntFunction<Person> toAge = Person::getAge;
}
        
//        Predicate<Person> oldEnoughToVote = (Person p) -> {
//            return p.getAge() >= 18;
//        };
        
//        Predicate<Person> oldEnoughToVoteExpanded = p -> {
//            int leastVotingAge = 18;
//            return p.getAge() >= leastVotingAge;
//        };
        
        // consumer pattern full.
//        Consumer<Person> howOld = (Person p) -> {
//        System.out.println(p.getName()
//                + " is "
//                + p.getAge()
//                + " years old.");
//        };
        
        // To int full:
//        ToIntFunction<Person> toAge = (Person p) -> {
//            return p.getAge();
//        };
        
        // to int reduced:
//        ToIntFunction<Person> toAge = p -> p.getAge();

        