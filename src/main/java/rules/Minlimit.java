package rules;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class Minlimit {
    @JsonProperty("default")
    public double mydefault;
    public double sec;
    public double desired;
}
