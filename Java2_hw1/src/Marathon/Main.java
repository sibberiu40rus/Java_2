/**
 * Java_2_Lesson_1
 * @autor Martynyuk Alexey
 */
package Marathon;

import Marathon.Obstacle.*;
import Marathon.Competitors.*;


public class Main {
    public static void main(String[] args) {
        Team team = new Team("Team",
                new Human("Jhon"),
                new Cat("Barsik"),
                new Dog("Rex"),
                new Human("Danny"));

        Course course = new Course(
                new Cross(400),
                new Wall(2),
                new Water(30),
                new Cross(200));

        course.doIt(team);
        team.infoTeam();

    }
}
