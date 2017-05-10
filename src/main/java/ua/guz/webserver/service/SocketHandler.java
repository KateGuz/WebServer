package ua.guz.webserver.service;

import ua.guz.webserver.entity.Request;
import ua.guz.webserver.entity.Response;
import ua.guz.webserver.util.RequestParser;
import ua.guz.webserver.util.ResponseHeadersConverter;

import java.io.*;
import java.net.Socket;

public class SocketHandler {
    private Socket socket;
    private String resourceLocation;

    public SocketHandler(Socket socket, String resourceLocation) {
        this.socket = socket;
        this.resourceLocation = resourceLocation;
    }

    public void process() throws IOException {
        String requestData = read();
        Request request = RequestParser.parse(requestData);
        Response response = ResponseGenerator.generate(request, resourceLocation);
        write(response);
    }

    private String read() throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder requestData = new StringBuilder();
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            requestData.append(line);
            requestData.append("\n");
        }
        return requestData.toString();
    }

    private void write(Response response) throws IOException {
        byte[] headersData = ResponseHeadersConverter.toByteArray(response);
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
             BufferedInputStream bufferedInputStream = new BufferedInputStream(response.getResponseBody())) {
            bufferedOutputStream.write(headersData);
            if (response.getResponseBody() != null) {
                byte[] bytes = new byte[1024];
                int read;
                while ((read = bufferedInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, read);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
