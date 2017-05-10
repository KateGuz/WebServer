package ua.guz.webserver.util;

import org.junit.Test;
import ua.guz.webserver.entity.Request;
import ua.guz.webserver.entity.RequestMethod;

import java.util.Map;

import static org.junit.Assert.*;

public class RequestParserTest {
    @Test
    public void testParse() throws Exception {
        // prepare
        String requestData = "GET /conf-2009.avi HTTP/1.0\n" +
                "Host: example.org\n" +
                "Accept : */*\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows 98)\n" +
                "Referer:http://example.org/";

        // when
        Request request = RequestParser.parse(requestData);

        // then
        assertEquals(RequestMethod.GET, request.getMethod());
        assertEquals("/conf-2009.avi", request.getUrl());
        Map<String, String> headers = request.getHeaders();
        assertEquals(4, headers.size());
        assertEquals("example.org", headers.get("Host"));
        assertEquals("*/*", headers.get("Accept"));
        assertEquals("Mozilla/4.0 (compatible; MSIE 5.0; Windows 98)", headers.get("User-Agent"));
        assertEquals("http://example.org/", headers.get("Referer"));
    }

}