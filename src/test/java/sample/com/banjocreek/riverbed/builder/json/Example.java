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
package sample.com.banjocreek.riverbed.builder.json;

import java.util.Objects;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import com.banjocreek.riverbed.builder.json.immutable.ImmutableJsonBuilders;

public enum Example implements Runnable {

    INTRO_OBJ {
        @Override
        public void run() {

            // @formatter:off
final JsonObject jobj = ImmutableJsonBuilders.object()
    .set("Name", "Carl P. Thornton")
    .array("Aliases")
        .add("Jonathan H. Thornberg")
        .add("Harry Q. Bovik")
.build();

final JsonObject expected = Json.createObjectBuilder()
    .add("Name", "Carl P. Thornton")
    .add("Aliases", Json.createArrayBuilder()
        .add("Jonathan H. Thornberg")
        .add("Harry Q. Bovik")
        .build())
.build();

assert Objects.equals(expected, jobj);
            // @formatter:on

        }
    },

    OBJ_DEFAULTS {
        @Override
        public void run() {

            // @formatter:off
final JsonArray startcmds = ImmutableJsonBuilders.array()
    .add("service tomcat start")
    .add("service nginx start")
.build();
final JsonArray stopcmds = ImmutableJsonBuilders.array()
    .add("service nginx stop")
    .add("service tomcat stop")
.build();

final JsonObject defaults = ImmutableJsonBuilders.object()
    .set("proto", "SSH")
    .set("host", "my.host.com")
    .array("commands")
        .add("ls -l")
.build();

final JsonObject start = ImmutableJsonBuilders.object()
    .set("commands", startcmds)
    .withDefault(defaults)
.build();
final JsonObject stop = ImmutableJsonBuilders.object()
    .set("commands", stopcmds)
    .withDefault(defaults)
.build();

final JsonObject expectedStart = Json
    .createObjectBuilder()
    .add("proto", "SSH")
    .add("host", "my.host.com")
    .add("commands",
            Json.createArrayBuilder()
                    .add("service tomcat start")
                    .add("service nginx start").build())
.build();
assert Objects.equals(expectedStart, start);

final JsonObject expectedStop = Json
    .createObjectBuilder()
    .add("proto", "SSH")
    .add("host", "my.host.com")
    .add("commands",
            Json.createArrayBuilder()
                    .add("service nginx stop")
                    .add("service tomcat stop").build())
.build();
assert Objects.equals(expectedStop, stop);
            // @formatter:on

        }
    }

    ;

}
