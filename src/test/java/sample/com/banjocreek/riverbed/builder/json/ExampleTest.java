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
package sample.com.banjocreek.riverbed.builder.json;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExampleTest {

    static {
        RunExamples.enableAssertions();
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(Example.values()).stream()
                .map(ex -> new Object[] { ex }).collect(Collectors.toList());
    }

    final Example example;

    public ExampleTest(final Example example) {
        this.example = example;
    }

    @Test
    public void testExample() {
        this.example.run();
    }

}
