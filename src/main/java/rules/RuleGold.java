package rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class RuleGold {
    @JsonProperty("EUROPE")
    public EUROPE eUROPE;
    @JsonProperty("APAC")
    public APAC aPAC;
    @JsonProperty("NAM")
    public NAM nAM;
}
