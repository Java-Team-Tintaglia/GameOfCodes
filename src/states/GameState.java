package states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import factories.StudentFactory;
import graphics.Assets;
import models.GameObject;
import models.programmingLanguages.*;
import models.students.NerdBoy;
import models.students.Student;
import models.wizards.KnowledgeWizard;
import models.wizards.Wizard;
import utils.Constants;

import static core.MapInitializor.generateProgrammingLanguage;
import static core.MapInitializor.generateWizard;

public class GameState extends State {
    public static List<GameObject> entities = new ArrayList<>();

    public static Student student = new NerdBoy(100, 100, "Misho");

    public static ProgrammingLanguage java = new Java(200, 100);
    public static ProgrammingLanguage javascript = new JavaScript(300, 100);
    public static ProgrammingLanguage php = new Php(400, 100);
    public static ProgrammingLanguage cplusplus = new CPlusPlus(500, 100);
    public static ProgrammingLanguage csharp = new CSharp(600, 100);

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
        java.draw(graphics);
        javascript.draw(graphics);
        cplusplus.draw(graphics);
        csharp.draw(graphics);
        php.draw(graphics);

        wizard.draw(graphics);

        //uncoment for test
        //generateWizard().draw(graphics);
        //generateProgrammingLanguage().draw(graphics);


    }

    @Override
    public void update() {
//pulnq gi rushno, zasega
        entities.add(student);
        entities.add(wizard);
        student.update();
        java.update();
        javascript.update();
        php.update();
        cplusplus.update();
        csharp.update();
    }


}
