/**
 * Java_2_Lesson_1
 * @autor Martynyuk Alexey
 */
package Marathon.Obstacle;

import Marathon.Competitor;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
