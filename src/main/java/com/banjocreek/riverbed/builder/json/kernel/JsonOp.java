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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public interface JsonOp {

    static JsonArray buildArray(final List<JsonOp> values) {
        final JsonArrayBuilder jbuf = Json.createArrayBuilder();
        values.forEach(op -> op.apply(jbuf));
        return jbuf.build();
    }

    static JsonObject buildObject(final Map<String, JsonOp> values) {
        final JsonObjectBuilder jbuf = Json.createObjectBuilder();
        values.forEach((k, op) -> {
            op.apply(k, jbuf);
        });
        return jbuf.build();
    }

    static JsonOp combine(final JsonOp origOp, final JsonArray ovr) {

        final JsonValueOp rval;
        if (origOp instanceof JsonValueOp) {
            rval = new JsonValueOp((JsonValueOp) origOp, ovr);
        } else {
            rval = new JsonValueOp(ovr);
        }
        return rval;

    }

    static JsonOp combine(final JsonOp origOp, final JsonObject ovr) {

        final JsonValueOp rval;
        if (origOp instanceof JsonValueOp) {
            rval = new JsonValueOp((JsonValueOp) origOp, ovr);
        } else {
            rval = new JsonValueOp(ovr);
        }
        return rval;

    }

    static JsonOp of(final BigDecimal value) {
        return new BigDecimalOp(value);
    }

    static JsonOp of(final BigInteger value) {
        return new BigIntegerOp(value);
    }

    static JsonOp of(final boolean value) {
        return new BooleanOp(value);
    }

    static JsonOp of(final double value) {
        return new BigDecimalOp(value);
    }

    static JsonOp of(final int value) {
        return new BigIntegerOp(value);
    }

    static JsonOp of(final JsonValue value) {
        return new JsonValueOp(value);
    }

    static JsonOp of(final long value) {
        return new BigIntegerOp(value);
    }

    static JsonOp of(final String value) {
        return new StringOp(value);
    }

    static JsonOp ofNull() {
        return new NullOp();
    }

    void apply(JsonArrayBuilder jbuf);

    void apply(String key, JsonObjectBuilder jbuf);

}
