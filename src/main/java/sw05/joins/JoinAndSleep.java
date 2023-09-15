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
package sw05.joins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstration von Join und Sleep - Aufgabe 3 - N1_EX_ThreadsSynch.
 */
public class JoinAndSleep {
    
    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);
    
    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread3 = new Thread(new JoinAndSleepTask("Task 3", 10), "Task 3");
        Thread thread2 = new Thread(new JoinAndSleepTask("Task 2", 10, thread3), "Task 2");
        Thread thread1 = new Thread(new JoinAndSleepTask("Task 1", 10, thread2), "Task 1");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
