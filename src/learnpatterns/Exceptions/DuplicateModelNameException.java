package learnpatterns.Exceptions;

public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException(String modelName)
    {
        super("This name is already presented: " + modelName);
    }
}
