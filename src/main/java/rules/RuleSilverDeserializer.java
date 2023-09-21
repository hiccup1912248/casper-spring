package rules;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;

public class RuleSilverDeserializer extends StdDeserializer<HashMap<String, Region>> {

    public RuleSilverDeserializer() {
        this(null);
    }

    public RuleSilverDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public HashMap<String, Region> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String europeRegionStr = node.get("EUROPE").toPrettyString();
        String apacRegionStr = node.get("APAC").toPrettyString();
        String namRegionStr = node.get("NAM").toPrettyString();

        HashMap<String, Region> parsedValue = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Region europe = objectMapper.readValue(europeRegionStr, Region.class);
        parsedValue.put("EUROPE", europe);

        Region nam = objectMapper.readValue(namRegionStr, Region.class);
        parsedValue.put("NAM", nam);

        Region apac = objectMapper.readValue(apacRegionStr, Region.class);
        parsedValue.put("APAC", apac);

        return parsedValue;
    }
}
