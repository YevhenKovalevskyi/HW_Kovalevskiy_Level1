package ru.geekbrains.homeworks.hw05.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");
        
        Person[] persons = new Person[5];
        persons[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persons[1] = new Person("Ivanov Pert", "Driver", "ivpert@mailbox.com", "882123456", 40000, 40);
        persons[2] = new Person("Ivanov Max", "Lawyer", "ivmax@mailbox.com", "873214567", 50000, 20);
        persons[3] = new Person("Ivanov Serg", "Baker", "ivserg@mailbox.com", "869874523", 60000, 50);
        persons[4] = new Person("Ivanov Nick", "Teacher", "ivnick@mailbox.com", "899452136", 70000, 60);
    
        log.info("Got a filled array of Person: {}", Arrays.toString(persons));
    
        System.out.println("\nAll persons:");
        Arrays.stream(persons).forEach(System.out::println);
        
        System.out.println("\nPersons older than 40 years:");
        Arrays.stream(persons)
                .filter(person -> person.getAge() > 40)
                .forEach(System.out::println);

        log.info("End program.\n");
    }
}
