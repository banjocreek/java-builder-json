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
package com.banjocreek.riverbed.builder.json.immutable;

import java.util.function.Function;

import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 * Factory for immutable JSON builders.
 */
public interface ImmutableJsonBuilders {

    /**
     * Create a new JSON array builder. Both the build and done methods will
     * produce identical results.
     *
     * @return new builder
     */
    public static JAry<JsonArray, JsonArray> array() {
        return new ImmutableJsonArrayBuilder<>(Function.identity(),
                Function.identity());
    }

    /**
     * Create a new JSON object builder. Both the build and done methods will
     * produce identical results.
     *
     * @return new builder
     */
    public static JObj<JsonObject, JsonObject> object() {
        return new ImmutableJsonObjectBuilder<>(Function.identity(),
                Function.identity());
    }

}
