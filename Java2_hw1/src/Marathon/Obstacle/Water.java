/**
 * Java_2_Lesson_1
 * @autor Martynyuk Alexey
 */
package Marathon.Obstacle;

import Marathon.Competitor;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }

}