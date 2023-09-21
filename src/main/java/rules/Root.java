package rules;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class Root {
    public String sym;
    public int min;
    public int limit;
    public Minlimit minlimit;
    public Level level;

    @JsonProperty("ruleSilver")
    @JsonDeserialize(using = RuleSilverDeserializer.class)
    public HashMap<String, Region> ruleSilver;
    @JsonProperty("ruleGold")
    @JsonDeserialize(using = RuleGoldDeserializer.class)
    public HashMap<String, Region> ruleGold;
}

