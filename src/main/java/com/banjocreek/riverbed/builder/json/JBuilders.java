package com.banjocreek.riverbed.builder.json;

import javax.json.JsonArray;
import javax.json.JsonObject;

public interface JBuilders {

    public static com.banjocreek.riverbed.builder.json.immutable.JAry<JsonArray, JsonArray> immutableArray() {
        throw new UnsupportedOperationException("NYI");
    }

    public static com.banjocreek.riverbed.builder.json.immutable.JObj<JsonObject, JsonObject> immutableObject() {
        throw new UnsupportedOperationException("NYI");
    }

    public static com.banjocreek.riverbed.builder.json.mutable.JAry<JsonArray> mutableArray() {
        throw new UnsupportedOperationException("NYI");
    }

    public static com.banjocreek.riverbed.builder.json.mutable.JObj<JsonObject> mutableObject() {
        throw new UnsupportedOperationException("NYI");
    }

}
