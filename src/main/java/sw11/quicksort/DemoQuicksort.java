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
package sw11.quicksort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] array = ThreadLocalRandom.current().ints(size).toArray();
        final ForkJoinPool pool = new ForkJoinPool();
        final QuicksortTask sortTask = new QuicksortTask(array.clone());
        long startTimeRecPool = System.currentTimeMillis();
        pool.invoke(sortTask);
        long endTimeRecPool = System.currentTimeMillis();
        LOG.info("QuicksortTask  : {} sec.", (endTimeRecPool - startTimeRecPool) / 1000);
        long startTimeRec = System.currentTimeMillis();
        QuicksortRecursive.quicksort(array);
        long endTimeRec = System.currentTimeMillis();
        LOG.info("QuicksortRec.  : {} sec.", (endTimeRec - startTimeRec) / 1000);
        long startTimeArray = System.currentTimeMillis();
        Arrays.sort(array.clone());
        long endTimeArray = System.currentTimeMillis();
        LOG.info("Arrays.sort    : {} sec.", (endTimeArray - startTimeArray) / 1000);
    }
}
