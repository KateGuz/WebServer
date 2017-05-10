package ua.guz.webserver.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.guz.webserver.entity.Request;
import ua.guz.webserver.entity.Response;
import ua.guz.webserver.entity.ResponseStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResponseGenerator {
    private static final String HTTP_VERSION = "HTTP/1.1";
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseGenerator.class);

    public static Response generate(Request request, String resourceLocation) throws FileNotFoundException {
        Response response = new Response();
        response.setHttpVersion(HTTP_VERSION);
        File resource = getResource(request, resourceLocation);
        if (resource.isDirectory()) {
            LOGGER.warn("Resource = {} is a directory", resource.getAbsolutePath());
            response.setStatus(ResponseStatus.BAD_REQUEST);
        } else if (resource.exists()) {
            response.setStatus(ResponseStatus.OK);
            response.setResponseBody(new FileInputStream(resource));
        } else {
            LOGGER.warn("Resource = {} was not found", resource.getAbsolutePath());
            response.setStatus(ResponseStatus.NOT_FOUND);
        }
        return response;
    }

    private static File getResource(Request request, String resourceLocation) {
        String url = request.getUrl();
        String resourcePath = resourceLocation + url;
        return new File(resourcePath);
    }
}
