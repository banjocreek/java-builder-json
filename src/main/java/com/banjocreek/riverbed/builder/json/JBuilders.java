/**
 * Copyright (C) Greg Wiley
 *
 * Licensed under the Apache License, Version 2.0 (the "License") under
 * one or more contributor license agreements. See the NOTICE file
 * distributed with this work for information regarding copyright
 * ownership. You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
