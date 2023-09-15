/*
 * Copyright 2023 Hochschule Luzern - Informatik.
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
package sw07.n31.atomic;

/**
 * Eine Demo für einen Zähler mit mehreren Threads.
 */
public final class DemoAtomicCounter {

    /**
     * Privater Konstruktor.
     */
    private DemoAtomicCounter() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int nThreads = 3;
        final AtomicCounter counter = new AtomicCounter();
        for (int i = 1; i <= nThreads; i++) {
            final AtomicCounterTask task = new AtomicCounterTask(counter);
            final Thread thread = new Thread(task, "T" + i + " : ");
            thread.start();
        }
    }
}
