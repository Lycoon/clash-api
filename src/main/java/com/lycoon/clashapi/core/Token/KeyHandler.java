package com.lycoon.clashapi.core.Token;

import com.google.gson.Gson;
import com.lycoon.clashapi.core.exception.IncorrectLoginCredentialException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyHandler {

    final static Gson gson = new Gson();

    public static <G> G deserialize(String res, Class<G> obj) throws IOException {
        return gson.fromJson(res, obj);
    }
    /**
     * This method returns the json as class for ease of use
     * @param username username of the user
     * @param password password associated with the above username
     * @return an Existing Keys available for the account
     * @throws IncorrectLoginCredentialException thrown on wrong username and password
     * @throws IOException thrown by gson
     */
    private ExistingKeyModel mapKeys(String username, String password) throws IncorrectLoginCredentialException, IOException {
        String keys = new KeyHttpRequest().getKeys(username, password);
       return deserialize(keys, ExistingKeyModel.class);
    }

    /**
     * this method calls the http method to revoke all the keys
     * @param keys array of keys present for the user
     * @param username username of the user
     * @param password password associated with the username
     * @throws IncorrectLoginCredentialException thrown on wrong username and password
     */
    private void revokeKeys(ExistingKeyModel.Key[] keys, String username, String password) throws IncorrectLoginCredentialException {
        new KeyHttpRequest().deleteAllKeys(keys, username, password);
    }

    /**
     * this is used map the json of newly created keys to a <code>KeyModel</code>
     * @param json String for
     * @return
     * @throws IOException
     */
    private KeyModel mapKeys(String json) throws IOException {
        return deserialize(json, KeyModel.class);
    }

    /**
     * to get the valid keys of an account
     * @param username username of the user
     * @param password password associated with the above username
     * @return a list of valid keys
     * @throws IncorrectLoginCredentialException thrown on wrong username and password
     * @throws IOException thrown by gson
     */

    public List<String> getValidKeys(String username, String password) throws IncorrectLoginCredentialException, IOException {
        String ip = getIP();
        ExistingKeyModel existingKeyModel = mapKeys(username, password);
        List<String> validKeys = new ArrayList<>();

        Arrays.stream(existingKeyModel.getKeys()).forEach(keyObj -> {
            List<String> collect = Arrays.stream(keyObj.getIps()).filter(i -> i.equalsIgnoreCase(ip)).collect(Collectors.toList());
            validKeys.addAll(collect);
        });

        if (validKeys.isEmpty()) {
            //Delete all the keys when no key is valid
            if (existingKeyModel.getKeys().length >= 10) {
                revokeKeys(existingKeyModel.getKeys(), username, password);
            }
            String createdKeys = new KeyHttpRequest().createKeys(username, password, ip);
            validKeys.add(mapKeys(createdKeys).getKeys().getKey());
        }
        return validKeys;
    }

    /**
     * to get the IP of the machine
     * @return the IP of the machine
     * @throws IOException
     */
    private String getIP() throws IOException {
        java.net.URL url = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));
        return in.readLine();
    }

}
