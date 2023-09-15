/*
 * Copyright 2023 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sw07.count;

import sw07.n31.atomic.AtomicOperations;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-sicherer Zähler mit AtomicInteger.
 */
public final class AtomicCounter implements Counter {

    AtomicInteger integer = new AtomicInteger();

    /**
     * Erzeugt einen Zähler mit Zählerstand 0.
     */
    public AtomicCounter() {
        integer.set(0);
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#increment()
     */
    @Override
    public void increment() {
        integer.getAndIncrement();
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#decrement()
     */
    @Override
    public void decrement() {
        integer.getAndDecrement();
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#get()
     */
    @Override
    public int get() {
        return integer.get();
    }
}
