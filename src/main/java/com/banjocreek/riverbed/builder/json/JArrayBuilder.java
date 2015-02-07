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

    public Z clear();

    public Z setNull();

    public Z withDefault(JsonArray jary);

    public Z withValues(JsonArray jary);

}
