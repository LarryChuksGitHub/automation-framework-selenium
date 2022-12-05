package tutorial.encoderanddeboder;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * Test class to encode and decode string
 * @see EncoderAndDecoder
 * {@link tutorial.dataprovider.DataProviderDemo}
 *
 *
 */
public class EncoderAndDecoder {


    public static void main(String[] args) {
       String encodedString = Base64.getEncoder().encodeToString("Larry  the king".getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);
       String decodedString = new String(Base64.getDecoder().decode(encodedString));
        System.out.println((decodedString));
    }
}
