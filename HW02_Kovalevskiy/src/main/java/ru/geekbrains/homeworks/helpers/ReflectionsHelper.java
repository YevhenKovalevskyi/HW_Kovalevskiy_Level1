package ru.geekbrains.homeworks.helpers;

/**
 * ReflectionsHelper Class is a helper class for different work with reflections
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
public class ReflectionsHelper {
    
    /**
     * The method gets the package name
     *
     * @return package name as String
     */
    public String getPackageName() {
        return this.getClass().getPackage().getName();
    }
    
    /**
     * The method gets the class name by the instance
     *
     * @param object class instance
     *
     * @return class name as String
     */
    public String getClassName(Object object) {
        return object.getClass().getName()
                .replace(this.getPackageName() + ".", "")
                .replace("$", ".");
    }
    
    /**
     * The method gets the name of the currently executing method
     *
     * @return method name as String
     */
    public String getMethodName(String source) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int index = (source.equals("main")) ? stackTrace.length - 2 : 1;
        
        return stackTrace[index].getMethodName();
    }
}
