package ua.guz.webserver.entity;

public enum RequestMethod {
    GET("GET");
    private String id;

    RequestMethod(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static RequestMethod getMethodById(String id){
        for (RequestMethod requestMethod : RequestMethod.values()) {
            if(requestMethod.getId().equals(id)){
                return requestMethod;
            }
        }
        throw new IllegalArgumentException("No request method found for id = " + id);
    }
}
