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
package com.banjocreek.riverbed.builder.json.mutable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.JsonArray;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.json.kernel.JsonOp;
import com.banjocreek.riverbed.builder.list.AbstractMutableListBuilder;

final class MutableJsonArrayBuilder<P> extends
        AbstractMutableListBuilder<JsonOp, P> implements JAry<P> {

    protected MutableJsonArrayBuilder(final Function<JsonArray, P> constructor) {
        super(l -> constructor.apply(JsonOp.buildArray(l)));
    }

    @Override
    public JAry<P> add(final BigDecimal value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final BigInteger value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final boolean value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final double value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final int value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final JsonValue value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final long value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final String value) {
        doAdd(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> addNull() {
        doAdd(JsonOp.ofNull());
        return this;
    }

    @Override
    public JAry<JAry<P>> array() {
        return new MutableJsonArrayBuilder<>(this::add);
    }

    @Override
    public JAry<P> clear() {
        doClear();
        return this;
    }

    @Override
    public JAry<P> concat(final JsonArray jary) {
        doAddAll(jary.stream().map(JsonOp::of).collect(Collectors.toList()));
        return this;
    }

    @Override
    public JObj<JAry<P>> object() {
        return new MutableJsonObjectBuilder<>(this::add);
    }

}
