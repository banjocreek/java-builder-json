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
import java.util.function.Function;

import javax.json.JsonObject;
import javax.json.JsonValue;

import com.banjocreek.riverbed.builder.json.kernel.JsonOp;
import com.banjocreek.riverbed.builder.map.AbstractImmutableMapBuilder;
import com.banjocreek.riverbed.builder.map.MapDelta;

final class ImmutableJsonObjectBuilder<R, P> extends
        AbstractImmutableMapBuilder<String, JsonOp, R, P> implements JObj<R, P> {

    ImmutableJsonObjectBuilder(final Function<JsonObject, R> rootConstructor,
            final Function<JsonObject, P> parentConstructor) {
        super(m -> rootConstructor.apply(JsonOp.buildObject(m)),
                m -> parentConstructor.apply(JsonOp.buildObject(m)));
    }

    private ImmutableJsonObjectBuilder(
            final AbstractImmutableMapBuilder<String, JsonOp, R, P> previous,
            final MapDelta<String, JsonOp> delta) {
        super(previous, delta);
        // TODO Auto-generated constructor stub
    }

    @Override
    public JAry<R, JObj<R, P>> array(final String name) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> clear() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, JObj<R, P>> object(final String name) {
        return new ImmutableJsonObjectBuilder<>(
                jobj -> set(name, jobj).build(), jobj -> set(name, jobj));

    }

    @Override
    public JObj<R, P> set(final String name, final BigDecimal value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final BigInteger value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final boolean value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final double value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final int value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final JsonValue value) {
        return new ImmutableJsonObjectBuilder<>(this, values(name,
                JsonOp.of(value)));
    }

    @Override
    public JObj<R, P> set(final String name, final long value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> set(final String name, final String value) {
        return new ImmutableJsonObjectBuilder<>(this, values(name,
                JsonOp.of(value)));
    }

    @Override
    public JObj<R, P> setNull(final String name) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> unset(final String name) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> withDefault(final JsonObject jobj) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<R, P> withValues(final JsonObject jobj) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

}
