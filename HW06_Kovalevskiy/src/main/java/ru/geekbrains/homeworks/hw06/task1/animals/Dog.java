package ru.geekbrains.homeworks.hw06.task1.animals;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.geekbrains.homeworks.hw06.task1.exceptions.ActionLimitExceededException;

@EqualsAndHashCode(callSuper = true)
@Value
public class Dog extends Animal {
    
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;
    
    String name;
    
    @Override
    public void run(int length) throws ActionLimitExceededException {
        if (length > Dog.RUN_LIMIT) {
            throw new ActionLimitExceededException("run", length, Dog.RUN_LIMIT);
        }
        
        System.out.printf("%s ran %d м.\n", this.name, length);
    }
    
    @Override
    public void swim(int length) throws ActionLimitExceededException {
        if (length > Dog.SWIM_LIMIT) {
            throw new ActionLimitExceededException("swim", length, Dog.SWIM_LIMIT);
        }
        
        System.out.printf("%s swam %d м.\n", this.name, length);
    }
}
