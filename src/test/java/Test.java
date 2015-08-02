import Utils.RestClient;
import Utils.Urlbuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.*;

import java.util.*;

public class Test {


    public static int hd_false = 0;
    public static int hd_true = 0;


    /* process flag field to check for hd json value */
    public void processRecord(String response) throws Exception {

        JSONObject json = new JSONObject(response);
        JSONArray dataJsonArray = json.getJSONArray("response");
      //  System.out.print(dataJsonArray.length());
        for (int i = 0; i < dataJsonArray.length(); i++) {
            JSONObject dataObj = (JSONObject) dataJsonArray.get(i);
            JSONObject Obj = dataObj.getJSONObject("flags");
            String hd = Obj.getString("hd");
           // System.out.print(hd + "\n");
            if (hd.equalsIgnoreCase("true")) {
                hd_true++;
            }
            if (hd.equalsIgnoreCase("false")) {
                hd_false++;
            }
        }
    }

    public void Solution() throws Exception {


        int Sol = 0, page = 1, flag = 1;
        String url = "";
        Urlbuilder urlbuilder = new Urlbuilder("http://api.viki.io/");
        RestClient restClient = new RestClient();
        urlbuilder.addSinglePathParam("v4");
        urlbuilder.addSinglePathParam("videos.json");
        Map<String, String> map = new HashMap<String, String>();
        map.put("app", "100250a");
        map.put("per_page", "10");
        urlbuilder.addQueryParamList(map);
        while (flag != 0) {
            //System.out.print(page+"------->");
            urlbuilder.addSingleQueryParam("page", String.valueOf(page));
            Response res = restClient.getRequest(urlbuilder.getUrl());
            /* check if status code =200 start processing response */
            if (res.getStatusCode() == 200) {
                String responsString = res.asString();
                JSONObject json = new JSONObject(responsString);
                String more = json.getString("more");
                if (more.equalsIgnoreCase("false")) {
                    flag = 0;
                } else {

                    processRecord(responsString);
                }
            }
            /* if not 200 then dont process that record response at all */
            else
            {
                System.out.print("Unable to get response" + res.statusCode());
            }
            page++;

        }
    }



    @org.testng.annotations.Test
    public void hdTest() throws Exception {

        Solution();
        System.out.print(hd_false+"\n");
        System.out.print(hd_true+"\n");


    }
}
