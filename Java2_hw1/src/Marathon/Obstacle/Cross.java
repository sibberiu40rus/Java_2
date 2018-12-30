/**
 * Java_2_Lesson_1
 * @autor Martynyuk Alexey
 */
package Marathon.Obstacle;

import Marathon.Competitor;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}