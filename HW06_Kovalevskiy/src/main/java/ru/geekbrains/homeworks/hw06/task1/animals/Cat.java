package ru.geekbrains.homeworks.hw06.task1.animals;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.geekbrains.homeworks.hw06.task1.exceptions.ActionLimitExceededException;

@EqualsAndHashCode(callSuper = true)
@Value
public class Cat extends Animal {

    private static int RUN_LIMIT = 200;
    private static int SWIM_LIMIT = 0;
    
    String name;
    
    @Override
    public void run(int length) throws ActionLimitExceededException {
        if (length > Cat.RUN_LIMIT) {
            throw new ActionLimitExceededException("run", length, Cat.RUN_LIMIT);
        }
        
        System.out.printf("%s ran %d м.\n", this.name, length);
    }
    
    @Override
    public void swim(int length) throws ActionLimitExceededException {
        if (length > Cat.SWIM_LIMIT) {
            throw new ActionLimitExceededException("swim", length, Cat.SWIM_LIMIT);
        }
        
        System.out.printf("%s swam %d м.\n", this.name, length);
    }
}
