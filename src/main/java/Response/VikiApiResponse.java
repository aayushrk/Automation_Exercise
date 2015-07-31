package Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Created by aayush.rk on 01/08/15.
 */
public class VikiApiResponse {


    @JsonProperty("more")
    @Getter
    @Setter
    public String more;

    @JsonProperty("response")
    @Getter @Setter
    public List<Responses> responses;
}
