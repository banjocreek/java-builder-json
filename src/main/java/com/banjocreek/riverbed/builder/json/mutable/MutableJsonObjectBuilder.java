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

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.json.kernel.JsonOp;
import com.banjocreek.riverbed.builder.map.AbstractMutableMapBuilder;

final class MutableJsonObjectBuilder<P> extends
        AbstractMutableMapBuilder<String, JsonOp, P> implements JObj<P> {

    protected MutableJsonObjectBuilder(final Function<JsonObject, P> constructor) {
        super(m -> constructor.apply(JsonOp.buildObject(m)));
    }

    @Override
    public JAry<JObj<P>> array(final String name) {
        return new MutableJsonArrayBuilder<>(jary -> set(name, jary));
    }

    @Override
    public JObj<P> clear() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<JObj<P>> continueArray(final String name) {
        return new MutableJsonArrayBuilder<>(jary -> update(name, jary));
    }

    @Override
    public JObj<JObj<P>> continueObject(final String name) {
        return new MutableJsonObjectBuilder<>(jobj -> update(name, jobj));
    }

    @Override
    public JObj<JObj<P>> object(final String name) {

        return new MutableJsonObjectBuilder<>(jobj -> set(name, jobj));
    }

    @Override
    public JObj<P> set(final String name, final BigDecimal value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final BigInteger value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final boolean value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final double value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final int value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final JsonValue value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final long value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> set(final String name, final String value) {
        doValues(name, JsonOp.of(value));
        return this;
    }

    @Override
    public JObj<P> setNull(final String name) {
        doValues(name, JsonOp.ofNull());
        return this;
    }

    @Override
    public JObj<P> unset(final String name) {
        doRemove(name);
        return this;
    }

    @Override
    public JObj<P> update(final String key, final JsonArray jobj) {
        doUpdates(key, jop -> JsonOp.combine(jop, jobj));
        return this;
    }

    @Override
    public JObj<P> update(final String key, final JsonObject jobj) {
        doUpdates(key, jop -> JsonOp.combine(jop, jobj));
        return this;
    }

    @Override
    public JObj<P> withDefault(final JsonObject jobj) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<P> withValues(final JsonObject jobj) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

}
