package com.lycoon.clashapi.core;

import com.google.gson.Gson;
import com.lycoon.clashapi.core.exception.*;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class CoreUtils
{
    public final static String URL = "https://api.clashofclans.com/";
    public final static String API_VERSION = "v1";
    final static Gson gson = new Gson();

    public static Response checkResponse(Response res) throws ClashAPIException
    {
        if (res.isSuccessful())
            return res;

        switch(res.code())
        {
            case 400:
                throw new BadRequestException();
            case 403:
                throw new AuthException();
            case 404:
                throw new NotFoundException();
            case 429:
                throw new RateLimitException();
            case 503:
                throw new MaintenanceException();
            default:
                throw new UnknownException();
        }
    }

    public static <T> T deserialize(Response res, Class<T> obj) throws IOException
    {
        T deserialized = gson.fromJson(Objects.requireNonNull(res.body()).string(), obj);
        res.close();

        return deserialized;
    }

    public static String formatTag(String tag)
    {
        if (tag.startsWith("#"))
            return tag.replace("#", "%23");
        return "%23" + tag;
    }
}
