/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 */
package com.google.code.morphia.mapping.validation.fieldrules;

import com.google.code.morphia.TestBase;
import com.google.code.morphia.annotations.Reference;
import com.google.code.morphia.mapping.validation.ConstraintViolationException;
import com.google.code.morphia.testutil.AssertedFailure;
import com.google.code.morphia.testutil.TestEntity;
import org.junit.Test;

/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 */
public class LazyReferenceOnArrayTest extends TestBase {

    static class LazyOnArray extends TestEntity {
        private static final long serialVersionUID = 1L;
        @Reference(lazy = true)
        private R[] r;
    }

    static class R extends TestEntity {
        private static final long serialVersionUID = 1L;
    }

    @Test
    public void testLazyRefOnArray() {
        new AssertedFailure(ConstraintViolationException.class) {

            @Override
            protected void thisMustFail() {
                morphia.map(LazyOnArray.class);
            }
        };
    }
}
