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
package com.banjocreek.riverbed.builder.json.kernel;

import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

final class JsonValueOp implements JsonOp {

    private final JsonValue value;

    public JsonValueOp(final JsonValue value) {
        this.value = Objects.requireNonNull(value);
    }

    public JsonValueOp(final JsonValueOp origOp, final JsonArray ovr) {

        final JsonArrayBuilder buf = Json.createArrayBuilder();

        if (origOp.value instanceof JsonArray) {
            ((JsonArray) origOp.value).forEach(buf::add);
        }
        ovr.forEach(buf::add);

        this.value = buf.build();

    }

    public JsonValueOp(final JsonValueOp origOp, final JsonObject ovr) {

        final JsonObjectBuilder buf = Json.createObjectBuilder();

        if (origOp.value instanceof JsonObject) {
            ((JsonObject) origOp.value).forEach(buf::add);
        }
        ovr.forEach(buf::add);

        this.value = buf.build();

    }

    @Override
    public void apply(final JsonArrayBuilder jbuf) {
        jbuf.add(this.value);
    }

    @Override
    public void apply(final String key, final JsonObjectBuilder jbuf) {
        jbuf.add(key, this.value);
    }

}
