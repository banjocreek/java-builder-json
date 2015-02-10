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
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * <p>
 * JSON Object builder interface. Defines the common builder operations for
 * objects. The mutable,
 * {@link com.banjocreek.riverbed.builder.json.mutable.JObj JObj}, and immutable
 * {@link com.banjocreek.riverbed.builder.json.immutable.JObj JObj}
 * sub-interfaces define nesting, merging, and building.
 * </p>
 *
 * @param <Z>
 *            actual builder type
 */

public interface JObjectBuilder<Z extends JObjectBuilder<Z>> {

    /**
     * Clear all state, including defaults.
     *
     * @return mutated builder
     */
    public Z clear();

    /**
     * Remove a value.
     *
     * @param name
     *            the key of the value to remove.
     *
     * @return mutated builder
     */
    public Z remove(String name);

    /**
     * Clear all state except for defaults.
     *
     * @return mutated builder
     */
    public Z reset();

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final BigDecimal value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final BigInteger value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final boolean value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final double value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final int value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final JsonValue value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final long value);

    /**
     * Set a value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     * @param value
     *            the value to set. Must not be null.
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name or value is null.
     */
    public Z set(final String name, final String value);

    /**
     * Set the JSON null value for a key.
     *
     * @param name
     *            the key of the value to set.
     *
     *
     * @return mutated builder
     *
     * @throws NullPointerException
     *             if name is null.
     */
    public Z setNull(final String name);

    /**
     * Append to array at a key. If the key is not present in the builder or if
     * it contains anything but an array, the value at the key is set to the
     * array parameter.
     *
     * @param name
     *            key of array to modify.
     *
     * @param with
     *            array containing values to append.
     *
     * @return mutated builder
     *
     */
    public Z update(final String name, final JsonArray with);

    /**
     * Override the object at a key. All values in the incoming object are
     * applied to the object at the key, replacing overlapping values in the
     * current object. If the key is not present in the builder or if it
     * contains anything but an object, the value at the key is set to the
     * object parameter.
     *
     * @param name
     *            key of array to modify.
     *
     * @param with
     *            array containing values to append.
     *
     * @return mutated builder
     *
     */
    public Z update(final String name, final JsonObject with);

    /**
     * Set the default values. Default values are present in the resulting
     * instance only if not overridden by the builder. Default values override
     * other default values without any memory. The order in which defaults are
     * applied with respect to normal values is not significant. Normal value
     * sets always override defaults.
     *
     * @param jobj
     *            object containing default values.
     *
     * @return mutated builder
     */
    public Z withDefault(JsonObject jobj);

    /**
     * Set values from another object. These override any current or default
     * values in the builder.
     *
     * @param jobj
     *            object containing override values.
     *
     * @return mutated builder
     */
    public Z withValue(JsonObject jobj);

}
