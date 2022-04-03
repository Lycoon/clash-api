package com.lycoon.clashapi.core.Token;

import com.lycoon.clashapi.core.exception.AuthException;
import com.lycoon.clashapi.core.exception.IncorrectLoginCredentialException;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class KeyHttpRequest {
    /**
     * Log in for the user
     * @param username username of the user
     * @param password password associated with the above username
     * @return a <code>HttpClient.Builder</code> which contains the cookie
     * @throws AuthException thrown on wrong username and password
     */
    protected HttpClient.Builder login(String username, String password) throws IncorrectLoginCredentialException {

        HttpClient.Builder client = HttpClient.newBuilder();
        CookieManager cookieManager = new CookieManager();

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers
                .ofString("{\"email\":\""+username+"\",\"password\":\""+password+"\"}");
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/login")
                )
                .header("authorization", "")
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher).build();

        AtomicInteger statusCode = new AtomicInteger();
        client.cookieHandler(cookieManager)
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(statusCode::set)
                .join();
        if (statusCode.get() != 200){
            throw new IncorrectLoginCredentialException();
        }
        return client;
    }

    /**
     * get all the existing keys for the user
     * @param username username of the user
     * @param password password associated with the above username
     * @return a Json string which can be converted to a class
     * @throws AuthException thrown on wrong username and password
     */
    protected String getKeys(String username, String password) throws IncorrectLoginCredentialException {
        HttpClient.Builder client = login(username, password);

        HttpRequest.BodyPublisher bodyPublisher1 = HttpRequest.BodyPublishers
                .ofString("");

        HttpRequest request1 = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/apikey/list"))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher1).build();

        return client.build()
                .sendAsync(request1, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

    }

    /**
     * Creates a single key for the user
     * @param username username of the user
     * @param password password associated with the above username
     * @param ip , ip address for the machine which will be accessing this lib
     * @return a Json string which can be converted to a class
     * @throws AuthException thrown on wrong username and password
     */
    protected String createKeys(String username, String password, String ip) throws IncorrectLoginCredentialException {
        HttpClient.Builder client = login(username, password);
        String json ="{\n" +
                "                    \"cidrRanges\":\n" +
                "                     [\"%s\"],\n" +
                "                      \"description\": \"Api key created by clashApi on %s\",\n" +
                "                      \"name\": \"JClash\",\n" +
                "                      \"scopes\": [\"clash\"]\n" +
                "                }";
        HttpRequest.BodyPublisher bodyPublisher1 = HttpRequest.BodyPublishers
                .ofString(String.format(json, ip, LocalDateTime.now().atZone(ZoneId.systemDefault()).toString()));

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/apikey/create"))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher1).build();

        return client.build().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     * Deletes all the key from the user
     * @param keys list of keys available for the user
     * @param username username of the user
     * @param password password associated with the above username
     * @throws AuthException thrown on wrong username and password
     */
    protected void deleteAllKeys (ExistingKeyModel.Key[] keys, String username, String password) throws IncorrectLoginCredentialException {
        HttpClient.Builder client = login(username, password);
        String json = "{\n" +
                "                        \"id\": \"%s\"\n" +
                "                    }";
        for (ExistingKeyModel.Key key : keys) {
            deleteKey(client, json, key);
        }
    }

    /**
     * deleted a single key for the user
     * @param client http builder
     * @param json POST request JSON
     * @param key needs to be deleted
     */
    private void deleteKey(HttpClient.Builder client, String json, ExistingKeyModel.Key key) {
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(String.format(json, key.getId()));

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/apikey/revoke"))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher)
                .build();
        client.build().sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();
    }
}
