package states;

import java.awt.Graphics;

import factories.StudentFactory;
import graphics.Assets;
import models.students.NerdBoy;
import models.students.Student;
import utils.Constants;

public class GameState extends State {

	public static Student student = new NerdBoy(100,100,"Misho");
	
	StudentFactory studentFactory = new StudentFactory();
	
	// TODO:
//	public GameState(StudentType studentType, String name) {
//		
//		student = studentFactory.create(studentType, x, y, name);
//	}

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.floor, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        
        student.draw(graphics);


    }

    @Override
    public void update() {


        student.update();
    }



}
