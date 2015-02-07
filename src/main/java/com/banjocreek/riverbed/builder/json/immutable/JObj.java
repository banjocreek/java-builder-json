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
import com.banjocreek.riverbed.builder.json.JObjectBuilder;

public interface JObj<R, P> extends JObjectBuilder<JObj<R, P>>,
        ImmutableBuilder<R, P> {

    JAry<R, JObj<R, P>> array(String name);

    JObj<R, JObj<R, P>> object(String name);

}