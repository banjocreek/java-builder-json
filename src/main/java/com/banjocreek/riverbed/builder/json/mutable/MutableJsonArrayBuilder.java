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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.json.JsonArray;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.AbstractMutableBuilder;
import com.banjocreek.riverbed.builder.json.kernel.JsonOp;

final class MutableJsonArrayBuilder<P> extends
        AbstractMutableBuilder<List<JsonOp>, JsonOp, P> implements JAry<P> {

    protected MutableJsonArrayBuilder(final Function<JsonArray, P> constructor) {
        super(ArrayList::new, (l, e) -> {
            l.add(e);
            return l;
        }, l -> constructor.apply(JsonOp.buildArray(l)));
    }

    @Override
    public JAry<P> add(final BigDecimal value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final BigInteger value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final boolean value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final double value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final int value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final JsonValue value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final long value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> add(final String value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<P> addNull() {
        apply(JsonOp.ofNull());
        return this;
    }

    @Override
    public JAry<JAry<P>> array() {
        return new MutableJsonArrayBuilder<>(this::add);
    }

    @Override
    public JAry<P> clear() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> concat(final JsonArray jary) {
        jary.stream().map(JsonOp::of).forEach(this::apply);
        return this;
    }

    @Override
    public JObj<JAry<P>> object() {
        return new MutableJsonObjectBuilder<>(this::add);
    }

}
