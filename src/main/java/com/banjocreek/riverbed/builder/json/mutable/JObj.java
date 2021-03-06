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

import com.banjocreek.riverbed.builder.MutableBuilder;
import com.banjocreek.riverbed.builder.json.JObjectBuilder;

/**
 * <p>
 * Mutable JSON object builder.
 * </p>
 *
 * @param <P>
 *            parent build type
 *
 */
public interface JObj<P> extends JObjectBuilder<JObj<P>>, MutableBuilder<P> {

    /**
     * Nest an array. This initializes a new builder whose array will be set in
     * this builder at the given key when it is completed.
     *
     * @param name
     *            key at which result will be set.
     *
     * @return nested array builder.
     */
    JAry<JObj<P>> array(String name);

    /**
     * Nest an array. If one has already been started at the given path, the
     * builder continues to operate on it. Otherwise, a new array is operated
     * upon as with {@link #array(String)}.
     *
     * @param name
     *            key of the array in the current builder.
     *
     * @return builder for nested array.
     */
    JAry<JObj<P>> continueArray(String name);

    /**
     * Nest an object. If one has already been started at the given path, the
     * builder continues to operate on it. Otherwise a new object is operated
     * upon as with {@link #object(String)}.
     *
     * @param name
     *            key of the object in the current builder.
     *
     * @return builder for nested object.
     */
    JObj<JObj<P>> continueObject(String name);

    /**
     * Nest an object. This initializes a new builder whose builder will be set
     * in this builder at the given key when it is completed.
     *
     * @param name
     *            key at which result will be set.
     *
     * @return nested object builder.
     */
    JObj<JObj<P>> object(String name);
}
