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
import javax.json.JsonArray;
import javax.json.JsonValue;

import org.junit.Before;
import org.junit.Test;

import com.banjocreek.riverbed.builder.json.immutable.ImmutableJsonBuilders;
import com.banjocreek.riverbed.builder.json.immutable.JAry;

public class ImmutableArrayBuilderAddTest {

    private JAry<JsonArray, JsonArray> builder;

    @Before
    public void setup() {
        this.builder = ImmutableJsonBuilders.array();
    }

    @Test
    public void testAddBigDecimal() {

        /*
         * given a builder and a value
         */
        // SETUP
        final BigDecimal v = BigDecimal.valueOf(12.3);

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddBigInteger() {

        /*
         * given a builder and a value
         */
        // SETUP
        final BigInteger v = BigInteger.valueOf(12L);

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddBoolean() {

        /*
         * given a builder and a value
         */
        // SETUP
        final boolean v = true;

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddDouble() {

        /*
         * given a builder and a value
         */
        // SETUP
        final double v = 12.3;

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddInteger() {

        /*
         * given a builder and a value
         */
        // SETUP
        final int v = 12;

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddJsonValue() {

        /*
         * given a builder and a value
         */
        // SETUP
        final JsonValue v = Json.createObjectBuilder().add("key", 12L).build()
                .get("key");

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddLong() {

        /*
         * given a builder and a value
         */
        // SETUP
        final long v = 12L;

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddNull() {

        /*
         * given a builder
         */
        // SETUP

        /*
         * when add null is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.addNull();

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().addNull().build();

        assertEquals(expected, actual);

    }

    @Test
    public void testAddString() {

        /*
         * given a builder and a value
         */
        // SETUP
        final String v = "Value";

        /*
         * when add is invoked with the value
         */
        final JAry<?, JsonArray> changed = this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = changed.done();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }

    @Test
    public void testConcat() {

        /*
         * given a builder with values and a completed json array
         */
        // SETUP
        final JAry<JsonArray, JsonArray> b1 = this.builder.add("A").add("B");
        final JsonArray addl = Json.createArrayBuilder().add("C").add("D")
                .build();

        /*
         * when append is invoked
         */
        final JAry<?, JsonArray> b2 = b1.concat(addl);

        /*
         * the additional values are appended to the resulting array
         */
        final JsonArray actual = b2.done();
        final JsonArray expected = Json.createArrayBuilder().add("A").add("B")
                .add("C").add("D").build();
        assertEquals(expected, actual);

    }

}
