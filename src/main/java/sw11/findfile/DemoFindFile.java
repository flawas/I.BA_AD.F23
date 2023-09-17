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
package sw11.findfile;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "test.properties";
        final File rootDir = new File(System.getProperty("user.home") + "/Github");
        LOG.info("Start searching '{}' recurive in '{}'", search, rootDir);
        long findFileStart = System.currentTimeMillis();
        FindFile.findFile(search, rootDir);
        long findFileEnd = System.currentTimeMillis();
        LOG.info("Found in {} msec.", (findFileEnd - findFileStart) / 1000);
        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        long findFileTaskStart = System.currentTimeMillis();
        final FindFileTask root = new FindFileTask(search, rootDir);
        LOG.info(root.invoke());
        long findFileTaskEnd = System.currentTimeMillis();
        LOG.info("Found in {} msec.", (findFileTaskEnd - findFileTaskStart) / 1000);
    }
}
