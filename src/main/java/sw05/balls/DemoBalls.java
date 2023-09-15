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
package sw05.balls;

/**
 * Demonstration von Bällen.
 */
public class DemoBalls {

    private static final Canvas canvas = Canvas.getCanvas();

    public static void main(final String[] args) {
        final String[] color = {"red", "black", "blue", "yellow", "green", "magenta"};
        canvas.setVisible(true);
        for(int i = 0; i < 20; i++) {
            final Thread thread = new Thread(new Ball());
            thread.start();
        }

    }
}
