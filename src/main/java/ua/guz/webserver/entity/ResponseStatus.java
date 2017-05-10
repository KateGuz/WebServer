package ua.guz.webserver.entity;

public enum ResponseStatus {
    OK("200 OK"), NOT_FOUND("404 Not Found"), BAD_REQUEST("400 Bad Request");
    private String id;

    ResponseStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ResponseStatus getStatusById(String id) {
        for (ResponseStatus responseStatus : ResponseStatus.values()) {
            if (responseStatus.getId().equals(id)) {
                return responseStatus;
            }
        }
        throw new IllegalArgumentException("No response status found for id = " + id);
    }
}
