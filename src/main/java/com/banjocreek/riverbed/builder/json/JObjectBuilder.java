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

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public interface JObjectBuilder<Z extends JObjectBuilder<Z>> {

    public Z clear();

    public Z remove(String name);

    public Z reset();

    public Z set(final String name, final BigDecimal value);

    public Z set(final String name, final BigInteger value);

    public Z set(final String name, final boolean value);

    public Z set(final String name, final double value);

    public Z set(final String name, final int value);

    public Z set(final String name, final JsonValue value);

    public Z set(final String name, final long value);

    public Z set(final String name, final String value);

    public Z setNull(final String name);

    public Z update(final String name, final JsonArray with);

    public Z update(final String name, final JsonObject with);

    public Z withDefault(JsonObject jobj);

    public Z withValue(JsonObject jobj);

}
