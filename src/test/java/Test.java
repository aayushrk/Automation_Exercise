import Utils.Urlbuilder;
import org.testng.annotations.*;

import java.util.*;

public class Test {


    public int Solution() {


        int Sol=0,page=1,flag=1;
        String url="";
        Urlbuilder urlbuilder = new Urlbuilder("http://api.viki.io/");
        List<String> paramList = new ArrayList<String>();
        paramList.add("v4");
        paramList.add("videos.json");
        url=urlbuilder.addPathParamList(paramList);
        Map<String,String> map = new HashMap<String, String>();
        map.put("app","100250a");
        map.put("per_page","10");
        urlbuilder.addQueryParamList(map);
        while(flag !=0)
        {
            urlbuilder.addSingleQueryParam("page",String.valueOf(page));

            page++;



        }
        return Sol;


    }


   @org.testng.annotations.Test
    public void hdTest()
   {



   }

}
