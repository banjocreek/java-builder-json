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
import javax.json.JsonValue;

/**
 * <p>
 * JSON Array builder interface. Defines the common builder operations for
 * arrays. The mutable,
 * {@link com.banjocreek.riverbed.builder.json.mutable.JAry JAry}, and immutable
 * {@link com.banjocreek.riverbed.builder.json.immutable.JAry JAry}
 * sub-interfaces define nesting, merging, and building.
 * </p>
 *
 * @param <Z>
 */
public interface JArrayBuilder<Z extends JArrayBuilder<Z>> {

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final BigDecimal value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final BigInteger value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final boolean value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final double value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final int value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final JsonValue value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final long value);

    /**
     * Add a value to the end of the array.
     *
     * @param value
     *            value to add.
     *
     * @return mutated builder
     */
    public Z add(final String value);

    /**
     * Add a JSON null value to the end of the array.
     *
     * @return mutated builder
     */
    public Z addNull();

    /**
     * Empty the builder. The result of this operation is a builder that will
     * create an empty array.
     *
     * @return mutated builder
     */
    public Z clear();

    /**
     * Append elements from an existing array.
     *
     * @param jary
     *            array with elements to add.
     *
     * @return mutated builder
     */
    public Z concat(JsonArray jary);

}
