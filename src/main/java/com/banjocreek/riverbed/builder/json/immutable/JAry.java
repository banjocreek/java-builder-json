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

import com.banjocreek.riverbed.builder.ImmutableBuilder;
import com.banjocreek.riverbed.builder.json.JArrayBuilder;

/**
 * <p>
 * Immutable JSON array builder.
 * </p>
 *
 * @param <R>
 *            root build type
 *
 * @param <P>
 *            parent build type
 *
 */
public interface JAry<R, P> extends JArrayBuilder<JAry<R, P>>,
        ImmutableBuilder<R, P> {

    /**
     * Nest an array. This initializes a new builder whose array will be
     * appended to this array when it is completed.
     *
     * @return nested array builder.
     */
    JAry<R, JAry<R, P>> array();

    /**
     * Nest an object. This initializes a new builder whose object will be
     * appended to this array when it is completed.
     *
     * @return nested object builder.
     */
    JObj<R, JAry<R, P>> object();

}
