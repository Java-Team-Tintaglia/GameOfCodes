package states;

import java.awt.Graphics;

import enums.StudentType;
import factories.StudentFactory;
import graphics.Assets;
import models.programmingLanguages.Java;
import models.programmingLanguages.ProgrammingLanguage;
import models.students.NerdBoy;
import models.students.Student;
import utils.Constants;

public class GameState extends State {
    private int y = 0;
    private int y2 = -600;

	//public static Student student = new NerdBoy(100,100,"Misho");

    public static ProgrammingLanguage p = new Java(200, 100);

	public static StudentFactory StudentFactory = new StudentFactory();

    public Student student;
    public StudentFactory studentFactory = new StudentFactory();
    public StudentType studentType;

    public GameState(StudentType studentType, String name, int x, int y) {
        student = studentFactory.create(studentType, x, y, name);
        this.studentType = studentType;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, 0, y, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.wall, 0, y2, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.floor, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        
        student.draw(graphics);
        p.draw(graphics);

        y++;
        y2++;

        if (y>=600){
            update();
        }
    }

    @Override
    public void update() {
        y = -600;
        y2 = 0;

        student.update();
        p.update();
    }



}
