package ru.geekbrains.homeworks.hw06.task1.exceptions;

public class ActionLimitExceededException extends Exception {
    
    private static final String ERROR_MESSAGE = "Can't %s %d m.! Maximum allowed distance: %d m.";
    
    String errorAction;
    int errorValue;
    int limitValue;
    
    public ActionLimitExceededException(String errorAction, int errorValue, int limitValue) {
        this.errorAction = errorAction;
        this.errorValue  = errorValue;
        this.limitValue  = limitValue;
    }
    
    public String getMessage() {
        return String.format(
                ActionLimitExceededException.ERROR_MESSAGE, this.errorAction, this.errorValue, this.limitValue
        );
    }
}
