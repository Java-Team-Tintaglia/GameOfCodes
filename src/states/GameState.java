package states;

import java.awt.Graphics;

import factories.StudentFactory;
import graphics.Assets;
import models.programmingLanguages.Java;
import models.programmingLanguages.ProgrammingLanguage;
import models.students.NerdBoy;
import models.students.Student;
import models.wizards.KnowledgeWizard;
import models.wizards.Wizard;
import utils.Constants;

public class GameState extends State {

	public static Student student = new NerdBoy(100,100,"Misho");

    public static ProgrammingLanguage p = new Java(200, 100);
    
    public static Wizard wizard = new KnowledgeWizard(300, 300);

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
        p.draw(graphics);
        wizard.draw(graphics);


       

    }

    @Override
    public void update() {


        student.update();
        p.update();
    }



}
