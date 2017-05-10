package ua.guz.webserver.service;

import org.junit.Test;
import ua.guz.webserver.entity.Request;
import ua.guz.webserver.entity.Response;
import ua.guz.webserver.entity.ResponseStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseGeneratorTest {
    @Test
    public void testGenerate() throws Exception {
        // prepare
        Request request = new Request();
        request.setUrl("/index.html");

        // when
        Response response = ResponseGenerator.generate(request, "src/test/resources/web");

        // then
        assertEquals("HTTP/1.1", response.getHttpVersion());
        assertEquals(ResponseStatus.OK, response.getStatus());
        assertNotNull(response.getResponseBody());
    }

}