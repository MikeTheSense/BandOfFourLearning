package learnpatterns.Exceptions;

public class ModelPriceOutOfBoundsException extends RuntimeException {
    public ModelPriceOutOfBoundsException()
    {
        super("Model price out of bounds!");
    }
}
