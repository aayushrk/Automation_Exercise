package Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by aayush.rk on 01/08/15.
 */
public class Responses {


    @JsonProperty("flags")
    @Getter
    @Setter
    public ResponseFLag flags;
}
