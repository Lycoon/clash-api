package com.lycoon.clashapi.core.Token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlinx.serialization.Serializable;

public class ExistingKeyModel {
    @SerializedName("keys")
    @Expose
    private Key[] keys;

    public Key[] getKeys() {
        return keys;
    }

    public class Key{
        @SerializedName("key")
        @Expose
        private String key;

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("cidrRanges")
        @Expose
        private String[] ips;

        public String getKey() {
            return key;
        }

        public String[] getIps() {
            return ips;
        }

        public String getId() { return id; }


    }
}
