package com.lycoon.clashapi.core.Token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyModel {
    @SerializedName("key")
    @Expose
    private KeyModel.Key keys;

    public KeyModel.Key getKeys() {
        return keys;
    }

    public class Key{
        @SerializedName("key")
        @Expose
        private String key;

        @SerializedName("cidrRanges")
        @Expose
        private String[] ips;

        public String getKey() {
            return key;
        }

        public String[] getIps() {
            return ips;
        }

    }
}
