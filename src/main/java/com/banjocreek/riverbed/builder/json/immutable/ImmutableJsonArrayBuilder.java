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
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javax.json.JsonArray;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.json.kernel.JsonOp;
import com.banjocreek.riverbed.builder.list.AbstractImmutableListBuilder;

public class ImmutableJsonArrayBuilder<R, P> extends
        AbstractImmutableListBuilder<JsonOp, R, P> implements JAry<R, P> {

    ImmutableJsonArrayBuilder(final Function<JsonArray, R> rootConstructor,
            final Function<JsonArray, P> parentConstructor) {
        super(l -> rootConstructor.apply(JsonOp.buildArray(l)),
                l -> parentConstructor.apply(JsonOp.buildArray(l)));
    }

    private ImmutableJsonArrayBuilder(
            final ImmutableJsonArrayBuilder<R, P> previous,
            final UnaryOperator<List<JsonOp>> delta) {
        super(previous, delta);
    }

    @Override
    public JAry<R, P> add(final BigDecimal value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final BigInteger value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final boolean value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final double value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final int value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final JsonValue value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final long value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> add(final String value) {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.of(value)));
    }

    @Override
    public JAry<R, P> addNull() {
        return new ImmutableJsonArrayBuilder<>(this, genAdd(JsonOp.ofNull()));
    }

    @Override
    public JAry<R, JAry<R, P>> array() {
        return new ImmutableJsonArrayBuilder<>(jary -> add(jary).build(),
                this::add);
    }

    @Override
    public JAry<R, P> clear() {
        return new ImmutableJsonArrayBuilder<>(this, genClear());
    }

    @Override
    public JAry<R, P> concat(final JsonArray jary) {

        return new ImmutableJsonArrayBuilder<>(this, genAddAll(jary.stream()
                .map(JsonOp::of).collect(Collectors.toList())));
    }

    @Override
    public JObj<R, JAry<R, P>> object() {
        return new ImmutableJsonObjectBuilder<>(jobj -> add(jobj).build(),
                this::add);
    }

}
