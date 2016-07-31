package interfaces;

import enums.WizardType;
import models.students.Student;

import java.awt.*;

/**
 * Created by PetyoPetrov on 31.07.2016 г..
 */
public interface Wizard {
    public boolean isExist();

    public void setExist(boolean exist);

    public Rectangle getColliderBox();

    public WizardType getWizardType();

    public abstract void boost(Student student);


    public void draw(Graphics graphics) ;


    public void update() ;

}
