package com.banjocreek.riverbed.builder.json;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.json.JsonObject;
import javax.json.JsonValue;

public interface JObjectBuilder<Z extends JObjectBuilder<Z>> {

    public Z clear();

    public Z set(final String name, final BigDecimal value);

    public Z set(final String name, final BigInteger value);

    public Z set(final String name, final boolean value);

    public Z set(final String name, final double value);

    public Z set(final String name, final int value);

    public Z set(final String name, final JsonValue value);

    public Z set(final String name, final long value);

    public Z set(final String name, final String value);

    public Z setNull(final String name);

    public Z unset(String name);

    public Z withDefault(JsonObject jobj);

    public Z withValues(JsonObject jobj);

}
