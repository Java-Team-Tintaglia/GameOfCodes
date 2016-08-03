package gameobject;

import graphics.Assets;
import interfaces.GameObject;
import models.wizards.IntelligenceWizard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameObjectTest {

    private static final int TEST_X_COORD = 100;
    private static final int TEST_Y_COORD = 100;

    @Before
    public void setUp(){
        Assets.init();
    }

    @Test
    public void correctValueForXCoord() throws Exception {
        GameObject wizard=new IntelligenceWizard(0,0);
        wizard.setX(TEST_X_COORD);
        int expected=100;
        int actualX=wizard.getX();
        Assert.assertEquals(expected,actualX);

    }

    @Test
    public void correctValueForYCoord() throws Exception {
        GameObject wizard=new IntelligenceWizard(0,0);
        wizard.setY(TEST_Y_COORD);
        int expected=100;
        int actualY=wizard.getY();
        Assert.assertEquals(expected,actualY);

    }
}