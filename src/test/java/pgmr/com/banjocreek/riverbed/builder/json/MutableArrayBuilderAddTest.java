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
import javax.json.JsonArray;

import org.junit.Before;
import org.junit.Test;

import com.banjocreek.riverbed.builder.json.mutable.JAry;
import com.banjocreek.riverbed.builder.json.mutable.MutableJsonBuilders;

public class MutableArrayBuilderAddTest {

    private JAry<JsonArray> builder;

    @Before
    public void setup() {
        this.builder = MutableJsonBuilders.array();
    }

    @Test
    public void testSetString() {

        /*
         * given a builder and a value
         */
        // SETUP
        final String v = "Value";

        /*
         * when set is invoked with the value
         */
        this.builder.add(v);

        /*
         * the builder is mutated with the parameters
         */
        final JsonArray actual = this.builder.merge();
        final JsonArray expected = Json.createArrayBuilder().add(v).build();

        assertEquals(expected, actual);

    }
}
