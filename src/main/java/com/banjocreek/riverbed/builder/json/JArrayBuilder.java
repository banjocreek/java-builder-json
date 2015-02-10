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
import javax.json.JsonValue;

public interface JArrayBuilder<Z extends JArrayBuilder<Z>> {

    public Z add(final BigDecimal value);

    public Z add(final BigInteger value);

    public Z add(final boolean value);

    public Z add(final double value);

    public Z add(final int value);

    public Z add(final JsonValue value);

    public Z add(final long value);

    public Z add(final String value);

    public Z addNull();

    public Z clear();

    public Z withDefault(JsonArray jary);

    public Z withValues(JsonArray jary);

}
