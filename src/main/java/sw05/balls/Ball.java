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
 * Description of class Ball
 */
public class Ball implements Runnable {

    private final Circle circle;
    private final int offset;

    private final int diameter = (int) (Math.random() * 31) + 20;

    public Ball(){
        int xPosition = (int) (Math.random() * 601);
        String color = RandomColorString.get();
        this.circle = new Circle(this.diameter, xPosition, 0, color);
        this.circle.makeVisible();
        this.offset = (int) (Math.random() * 10 + 1);
    }


    @Override
    public void run() {
        while (this.circle.getY() < 400 - this.diameter) {
            this.circle.moveVertical(offset);
        }
        for(int i = this.diameter; i > 0; i--){
            this.circle.moveVertical(1);
            this.circle.changeSize(i);
        }
        this.circle.makeInvisible();
    }
}
