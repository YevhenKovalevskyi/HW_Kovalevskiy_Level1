package ru.geekbrains.homeworks.hw06.task1.animals;

import lombok.Data;
import ru.geekbrains.homeworks.hw06.task1.exceptions.ActionLimitExceededException;
import ru.geekbrains.homeworks.hw06.task1.helpers.ReflectionsHelper;

@Data
public abstract class Animal {
    
    String name;
    
    public String getAnimalType() {
        return new ReflectionsHelper().getClassName(this);
    }
    
    public abstract void run(int length) throws ActionLimitExceededException;
    public abstract void swim(int length) throws ActionLimitExceededException;
}
