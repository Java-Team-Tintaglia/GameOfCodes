package models;


import graphics.Assets;
import interfaces.Student;
import interfaces.Wizard;
import models.students.BadBoy;
import models.wizards.IntelligenceWizard;
import models.wizards.KnowledgeWizard;
import models.wizards.VitalityWizard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WizardTest {

    private static final int TEST_X_COORD = 100;
    private static final int TEST_Y_COORD = 100;


    @Before
    public void setUp() {
        Assets.init();

    }

    @Test
    public void constructorIntelligenceWizard_Check_Correctness() {
       Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(intelligenceWizard);
    }

    @Test
    public void constructorKnowledgeWizard_Check_Correctness() {
        Wizard knowledgeWizard = new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(knowledgeWizard);
    }

    @Test
    public void constructorVitalityWizard_Check_Correctness() {
        Wizard vitalityWizard = new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(vitalityWizard);
    }

    @Test
    public void testBoost_Intelligence()  {
        Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,"TEST","TEST");
        int expectedBedBoyIntelligence = 65;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence();
        Assert.assertEquals(expectedBedBoyIntelligence, actual);

    }

    @Test
    public void testBoost_Knowledge() {
        Wizard  knowledgeWizard= new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,"TEST","TEST");
        int expectedBadBoyKnowledge =75;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge();
        Assert.assertEquals(expectedBadBoyKnowledge, actual);
    }

    @Test
    public void testBoost_Vitality() {
        Wizard  vitalityWizard= new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,"TEST","TEST");
        int expectedVitality =90;
        student.setVitality(60);
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedVitality, actual);
    }
}
