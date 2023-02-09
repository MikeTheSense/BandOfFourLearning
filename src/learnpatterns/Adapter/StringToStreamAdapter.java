package learnpatterns.Adapter;

import java.io.IOException;
import java.io.OutputStream;

public interface StringToStreamAdapter {
    void convertStringToStream(String[] string, OutputStream os) throws IOException;
}
