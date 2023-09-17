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
package sw11.fibo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(sw11.fibo.DemoFibonacciCalc.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFibonacciCalc() {
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int n = 50;
        final FibonacciTask task = new FibonacciTask(n);
        LOG.info("fibo({}) start...", n);
        long forkJoinStart = System.currentTimeMillis();
        long result = task.invoke();
        long forkJoinEnd = System.currentTimeMillis();
        LOG.info("Conc. recursive = {}", result);
        LOG.info("Conc. recursive : {} msec.", (forkJoinEnd - forkJoinStart) / 1000);
        long iterativeStart =  System.currentTimeMillis();
        result = fiboIterative(n);
        long iterativeEnd = System.currentTimeMillis();
        LOG.info("Func. iterative = {}", result);
        LOG.info("Func. iterative : {} msec.", (iterativeEnd - iterativeStart) / 1000);
        long fiboRecStart = System.currentTimeMillis();
        result = fiboRecursive(n);
        long fiboRecEnd = System.currentTimeMillis();
        LOG.info("Func. recursive = {}", result);
        LOG.info("Func. recursive : {} sec.", (fiboRecEnd - fiboRecStart) / 1000);
    }
}
