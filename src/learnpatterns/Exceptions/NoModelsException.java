package learnpatterns.Exceptions;

public class NoModelsException extends RuntimeException {
    public NoModelsException() {
        super("Models aren't presented!");
    }
}
