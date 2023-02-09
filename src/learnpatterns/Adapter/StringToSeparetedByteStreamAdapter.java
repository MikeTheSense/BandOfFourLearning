package learnpatterns.Adapter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StringToSeparetedByteStreamAdapter implements StringToStreamAdapter{

    @Override
    public void convertStringToStream(String[] strings, OutputStream os) throws IOException {
        for (String string : strings) {
            os.write(string.getBytes(StandardCharsets.UTF_8));
            os.write('\n');
        }
        os.flush();
    }
}