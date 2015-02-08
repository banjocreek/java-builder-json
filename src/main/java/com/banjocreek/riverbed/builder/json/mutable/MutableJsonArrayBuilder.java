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
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final BigInteger value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final boolean value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final double value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final int value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final JsonValue value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final long value) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> add(final String value) {
        apply(JsonOp.of(value));
        return this;
    }

    @Override
    public JAry<JAry<P>> array() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> clear() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JObj<JAry<P>> object() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> setNull() {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> withDefault(final JsonArray jary) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

    @Override
    public JAry<P> withValues(final JsonArray jary) {
        // TODO Auto-generated method stub
        // return null;
        throw new UnsupportedOperationException("NYI");
    }

}
