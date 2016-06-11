package states;

import repositories.StudentScoresRepository;

import java.awt.*;
import java.util.Map;

import static repositories.StudentScoresRepository.students;

public class ScoresStates extends State {

    @Override
    public void draw(Graphics graphics) {
        StudentScoresRepository.readFromFile();

        Font font = new Font("Basic Latin", Font.ITALIC, 20);
        graphics.setFont(font);
        graphics.setColor(Color.black);

        //TODO: Fix the List issue
        //for(Map.Entry<String, LinkedHashMap<String, List<Integer>>> student : students.entrySet()){
            //TODO: print high scores on screen
        //}
    }

    @Override
    public void update() {

    }
}
