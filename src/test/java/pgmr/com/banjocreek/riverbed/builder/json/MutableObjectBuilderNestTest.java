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

public class MutableObjectBuilderNestTest {

    private JObj<JsonObject> builder;

    @Before
    public void setup() {
        this.builder = MutableJsonBuilders.object();
    }

    @Test
    public void testContinuedObject() {

        /*
         * given a builder with a completed nested object
         */
        // SETUP
        final String k1 = "key one", k2 = "key two";
        final String v2 = "Value2";
        this.builder.object(k1).set(k2, v2).merge();

        /*
         * given an additional key and value
         */
        final String k3 = "key three";
        final String v3 = "Value3";

        /*
         * when the nested object is continued and modified
         */
        this.builder.continueObject(k1).set(k3, v3).merge();

        /*
         * the builder will produce the combination of nested changes
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json
                .createObjectBuilder()
                .add(k1,
                        Json.createObjectBuilder().add(k2, v2).add(k3, v3)
                                .build()).build();
        assertEquals(expected, actual);
    }

    @Test
    public void testNestedObject() {

        /*
         * given a builder, keys and value
         */
        // SETUP
        final String k1 = "key one", k2 = "key two";
        final String v = "Value";

        /*
         * when a nested object builder is created for one key and the value is
         * set in the nested builder under the second key
         */
        this.builder.object(k1).set(k2, v).merge();

        /*
         * the builder is mutated such that it creates corresponding nested
         * objects
         */
        final JsonObject actual = this.builder.merge();
        final JsonObject expected = Json.createObjectBuilder()
                .add(k1, Json.createObjectBuilder().add(k2, v).build()).build();

        assertEquals(expected, actual);

    }

}
