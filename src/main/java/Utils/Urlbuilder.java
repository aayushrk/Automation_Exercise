package Utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by aayush.rk on 31/07/15.
 */
public class Urlbuilder {


@Getter @Setter
    String url;


    public Urlbuilder(String url) {
        this.url = url;
    }

    public void addQueryParamList(Map<String, String> parameters) {
        url = url + "?";
        Iterator it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            url = url + pairs.getKey() + "=" + pairs.getValue();
            if (it.hasNext())
                url = url + "&";
        }

    }

    public void addSingleQueryParam(String name, String value) {
        url = url + "?" + name + "=" + value;
    }

    public void addSinglePathParam(String name) {
        url = url + name + "/";
    }

}

