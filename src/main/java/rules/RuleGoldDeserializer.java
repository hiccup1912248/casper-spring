package rules;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;

public class RuleGoldDeserializer extends StdDeserializer<HashMap<String, Region>> {

    public RuleGoldDeserializer() {
        this(null);
    }

    public RuleGoldDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public HashMap<String, Region> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Region> parsedValue = new HashMap<>();

        /*  EUROPE region info */
        Region europe = new Region();
        HashMap<String, Category> europeCategory = new HashMap<>();
        String europeCataStr = node.get("EUROPE").get("CATA").toString();
        Category europeCata = objectMapper.readValue(europeCataStr, Category.class);
        europeCategory.put("CATA", europeCata);

        String europeCatbStr = node.get("EUROPE").get("CATB").toString();
        Category europeCatb = objectMapper.readValue(europeCatbStr, Category.class);
        europeCategory.put("CATB", europeCatb);

        String europeCatcStr = node.get("EUROPE").get("CATC").toString();
        Category europeCatc = objectMapper.readValue(europeCatcStr, Category.class);
        europeCategory.put("CATC", europeCatc);

        europe.category = europeCategory;
        parsedValue.put("EUROPE", europe);

        /*  APAC region info */
        Region apac = new Region();
        HashMap<String, Category> apacCategory = new HashMap<>();
        String apacCataStr = node.get("APAC").get("CATA").toString();
        Category apacCata = objectMapper.readValue(apacCataStr, Category.class);
        apacCategory.put("CATA", apacCata);

        String apacCatbStr = node.get("APAC").get("CATB").toString();
        Category apacCatb = objectMapper.readValue(apacCatbStr, Category.class);
        apacCategory.put("CATB", apacCatb);

        String apacCatcStr = node.get("APAC").get("CATC").toString();
        Category apacCatc = objectMapper.readValue(apacCatcStr, Category.class);
        apacCategory.put("CATC", apacCatc);

        apac.category = apacCategory;
        parsedValue.put("APAC", apac);

        /*  NAM region info */
        Region nam = new Region();
        HashMap<String, Category> namCategory = new HashMap<>();
        String namCataStr = node.get("NAM").get("CATA").toString();
        Category namCata = objectMapper.readValue(namCataStr, Category.class);
        namCategory.put("CATA", namCata);

        String namCatbStr = node.get("NAM").get("CATB").toString();
        Category namCatb = objectMapper.readValue(namCatbStr, Category.class);
        namCategory.put("CATB", namCatb);

        String namCatcStr = node.get("NAM").get("CATC").toString();
        Category namCatc = objectMapper.readValue(namCatcStr, Category.class);
        namCategory.put("CATC", namCatc);

        nam.category = namCategory;
        parsedValue.put("NAM", nam);

        return parsedValue;
    }
}
