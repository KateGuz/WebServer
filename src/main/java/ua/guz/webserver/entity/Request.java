package ua.guz.webserver.entity;

import java.util.Map;

public class Request {
    private RequestMethod method;
    private String url;
    private String httpVersion;
    private Map<String, String> headers;

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
