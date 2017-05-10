package ua.guz.webserver.entity;

import java.io.InputStream;
import java.util.Map;

public class Response {
    private String httpVersion;
    private ResponseStatus status;
    private InputStream responseBody;

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public InputStream getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(InputStream responseBody) {
        this.responseBody = responseBody;
    }
}
