package learnpatterns.Exceptions;

public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException(String modelName)
    {
        super("Can't find model with a such name: " + modelName);
    }
}

