package Utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.*;
public class RestClient {

    public RestClient(){

    }

    static {
        RestAssured.config = config().logConfig(new LogConfig().enableLoggingOfRequestAndResponseIfValidationFails().enablePrettyPrinting(true));
        RestAssured.baseURI = "";
        RestAssured.basePath = "";
        RestAssured.useRelaxedHTTPSValidation();
    }

    public Response getRequest(String url)
    {
        //returns response object
        return get(url);
    }
}
