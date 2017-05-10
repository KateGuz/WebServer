package ua.guz.webserver.util;

import ua.guz.webserver.entity.Response;

public class ResponseHeadersConverter {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static byte[] toByteArray(Response response) {
        String headers = response.getHttpVersion() +
                SPACE +
                response.getStatus().getId() +
                NEW_LINE +
                NEW_LINE;
        return headers.getBytes();
    }
}
