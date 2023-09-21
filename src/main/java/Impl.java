import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import rules.Root;

import java.io.IOException;

import java.nio.file.Paths;
import java.util.Arrays;

public class Impl {

    private static final ObjectMapper mapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {

        return new ObjectMapper();
    }

    public static <A> A fromFileToJson(String path, Class<A> clazz) throws IOException {

        return mapper.readValue(Paths.get(path).toFile(), clazz);
    }

    public static void main(String[] args) throws IOException {
        Root[] rules = fromFileToJson("E:/Java/Casper/src/main/resources/test-rules.json", Root[].class);

        Arrays.asList(rules).forEach(System.out::println);


    }


}
