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
package pgmr.com.banjocreek.riverbed.builder.json;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.junit.Before;
import org.junit.Test;

import com.banjocreek.riverbed.builder.json.mutable.JObj;
import com.banjocreek.riverbed.builder.json.mutable.MutableJsonBuilders;

public class MutableObjectBuilderOpTest {

    private JObj<JsonObject> builder;

    @Before
    public void setup() {
        this.builder = MutableJsonBuilders.object();
    }

    @Test
    public void testClear() {

        /*
         * given a builder with defaults and values
         */
        // SETUP
        this.builder.withValue(
                Json.createObjectBuilder().add("b", "BB").add("c", "CC")
                        .build())
                .withDefault(
                        Json.createObjectBuilder().add("a", "A").add("b", "BB")
                                .build());

        /*
         * when clear is invoked
         */
        this.builder.clear();

        /*
         * the builder will create an empty instance
         */
        assertTrue(this.builder.merge().isEmpty());

    }

    @Test
    public void testDefault() {

        /*
         * given a builder and an object
         */
        // SETUP
        final JsonObject jdef = Json.createObjectBuilder().add("a", "A")
                .add("b", "B").build();

        /*
         * when object is used as default
         */
        this.builder.withDefault(jdef);

        /*
         * the created object has the defaults.
         */
        assertEquals(jdef, this.builder.merge());

    }

    @Test
    public void testDefaultDoesNotOverrideValue() {

        /*
         * given a builder with values
         */
        // SETUP
        final JsonObject jval = Json.createObjectBuilder().add("b", "BB")
                .add("c", "CC").build();
        this.builder.withValue(jval);

        /*
         * when overlapping defaults are set
         */
        this.builder.withDefault(Json.createObjectBuilder().add("a", "A")
                .add("b", "B").build());

        /*
         * the builder will create an instance overlapping values taking
         * precedence.
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add("a", "A")
                .add("b", "BB").add("c", "CC").build();
        assertEquals(expected, actual);

    }

    @Test
    public void testRemove() {

        /*
         * given keys, values and builder with values at keys
         */
        // SETUP
        final String k1 = "Key1", k2 = "Key2";
        final String v1 = "Value1", v2 = "Value2";
        this.builder.set(k1, v1).set(k2, v2);

        /*
         * when a key is unset
         */
        this.builder.remove(k1);

        /*
         * the builder will emit an instance without the key but with the
         * others.
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k2, v2)
                .build();
        assertEquals(expected, actual);

    }

    @Test
    public void testReset() {

        /*
         * given defaults and a builder with the defaults and some other values
         */
        // SETUP
        final JsonObject jdef = Json.createObjectBuilder().add("a", "A")
                .add("b", "BB").build();
        this.builder.withValue(
                Json.createObjectBuilder().add("b", "BB").add("c", "CC")
                        .build()).withDefault(jdef);

        /*
         * when reset is invoked
         */
        this.builder.reset();

        /*
         * the builder will create an instance with just the defaults
         */
        assertEquals(jdef, this.builder.merge());

    }

    @Test
    public void testSetBigDecimal() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final BigDecimal v = BigDecimal.valueOf(101.3);

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetBigInteger() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final BigInteger v = BigInteger.valueOf(101010L);

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetBoolean() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final boolean v = true;

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetDouble() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final double v = 10101.1;

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetInteger() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final int v = 10101;

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetJsonValue() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final JsonValue v = Json.createObjectBuilder().add("key", 12).build()
                .get("key");

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetLong() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final long v = 10101l;

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetNull() {

        /*
         * given a builder and a key
         */
        // SETUP
        final String k = "Key";

        /*
         * when set null is invoked with the key and value
         */
        this.builder.setNull(k);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().addNull(k)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetString() {

        /*
         * given a builder, a key, and a value
         */
        // SETUP
        final String k = "Key";
        final String v = "Value";

        /*
         * when set is invoked with the key and value
         */
        this.builder.set(k, v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder().add(k, v)
                .build();

        assertEquals(expected, actual);

    }

    @Test
    public void testUpdateArray() {

        /*
         * given a key and builder with a json array at the key
         */
        final String k = "Key";
        this.builder
                .set(k, Json.createArrayBuilder().add("A").add("B").build());

        /*
         * when update is invoked with another array
         */
        this.builder.update(k, Json.createArrayBuilder().add("C").add("D")
                .build());

        /*
         * the builder produces an instance with the combined values at the key,
         * the second after the first.
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json
                .createObjectBuilder()
                .add(k,
                        Json.createArrayBuilder().add("A").add("B").add("C")
                                .add("D").build()).build();
        assertEquals(expected, actual);

    }

    @Test
    public void testUpdateObject() {

        /*
         * given a key and builder with a json object value for the key
         */
        final String k = "Key";
        final JsonObject v = Json.createObjectBuilder().add("a", "A")
                .add("b", "B").build();
        this.builder.set(k, v);

        /*
         * when update is invoked with an overlapping value for the same key
         */
        this.builder
                .update(k,
                        Json.createObjectBuilder().add("c", "C").add("b", "BB")
                                .build());

        /*
         * the builder produces an instance with the combined values at the key,
         * the second overriding the first.
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json
                .createObjectBuilder()
                .add(k,
                        Json.createObjectBuilder().add("a", "A").add("c", "C")
                                .add("b", "BB").build()).build();
        assertEquals(expected, actual);

    }

    @Test
    public void testValue() {

        /*
         * given a builder and an object
         */
        // SETUP
        final JsonObject jval = Json.createObjectBuilder().add("b", "BB")
                .add("c", "CC").build();

        /*
         * when object is used as values
         */
        this.builder.withValue(jval);

        /*
         * the created object has the defaults.
         */
        assertEquals(jval, this.builder.merge());

    }

}
