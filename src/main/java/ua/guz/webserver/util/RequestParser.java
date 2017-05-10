package ua.guz.webserver.util;

import ua.guz.webserver.entity.Request;
import ua.guz.webserver.entity.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    public static Request parse(String requestData) {
        Request request = new Request();
        String[] requestLines = requestData.split("\n");
        String[] params = requestLines[0].split(" ");
        request.setMethod(RequestMethod.getMethodById(params[0]));
        request.setUrl(params[1]);
        request.setHttpVersion(params[2]);
        Map<String, String> headers = new HashMap<>();
        for (int i = 1; i < requestLines.length; i++) {
            int index = requestLines[i].indexOf(":");
            String key = requestLines[i].substring(0, index).trim();
            String value = requestLines[i].substring(index + 1).trim();
            headers.put(key, value);
        }
        request.setHeaders(headers);
        return request;
    }
}
