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
package com.banjocreek.riverbed.builder.json.immutable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.json.JsonArray;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.AbstractImmutableBuilder;
import com.banjocreek.riverbed.builder.json.kernel.JsonOp;

public class ImmutableJsonArrayBuilder<R, P> extends
        AbstractImmutableBuilder<List<JsonOp>, JsonOp, R, P> implements
        JAry<R, P> {

    ImmutableJsonArrayBuilder(final Function<JsonArray, R> rootConstructor,
            final Function<JsonArray, P> parentConstructor) {
        super(ArrayList::new, (l, e) -> {
            l.add(e);
            return l;
        }, l -> rootConstructor.apply(JsonOp.buildArray(l)),
                l -> parentConstructor.apply(JsonOp.buildArray(l)));
    }

    private ImmutableJsonArrayBuilder(
            final ImmutableJsonArrayBuilder<R, P> previous, final JsonOp delta) {
        super(previous, delta);
    }

    @Override
    public JAry<R, P> add(final BigDecimal value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final BigInteger value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final boolean value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final double value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final int value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final JsonValue value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final long value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> add(final String value) {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.of(value));
    }

    @Override
    public JAry<R, P> addNull() {
        return new ImmutableJsonArrayBuilder<>(this, JsonOp.ofNull());
    }

    @Override
    public JAry<R, JAry<R, P>> array() {
        return new ImmutableJsonArrayBuilder<>(jary -> add(jary).build(),
                this::add);
    }

    @Override
    public JAry<R, P> clear() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<R, P> concat(final JsonArray jary) {

        return new ImmutableJsonArrayBuilder<>(this, JsonOp.ofFlat(jary));
    }

    @Override
    public JObj<R, JAry<R, P>> object() {
        return new ImmutableJsonObjectBuilder<>(jobj -> add(jobj).build(),
                this::add);
    }

}
