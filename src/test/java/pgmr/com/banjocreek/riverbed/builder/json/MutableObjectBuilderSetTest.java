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

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import com.banjocreek.riverbed.builder.json.mutable.JObj;
import com.banjocreek.riverbed.builder.json.mutable.MutableJsonBuilders;

public class MutableObjectBuilderSetTest {

    private JObj<JsonObject> builder;

    @Before
    public void setup() {
        this.builder = MutableJsonBuilders.object();
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

}
