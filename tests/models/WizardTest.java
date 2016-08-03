package models;


import graphics.Assets;
import interfaces.Student;
import interfaces.Wizard;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import models.wizards.IntelligenceWizard;
import models.wizards.KnowledgeWizard;
import models.wizards.VitalityWizard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WizardTest {

    private static final int TEST_X_COORD = 100;
    private static final int TEST_Y_COORD = 100;
    private static final String TEST_NAME = "TEST";
    private static final String TEST_FULL_NAME = "TEST";


    @Before
    public void setUp() {
        Assets.init();

    }

    @Test
    public void constructorIntelligenceWizardShouldNotBeNull() {
       Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(intelligenceWizard);
    }
    @Test
    public void constructorKnowledgeWizardShouldNotBeNull() {
        Wizard knowledgeWizard = new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(knowledgeWizard);
    }
    @Test
    public void constructorVitalityWizardShouldNotBeNull() {
        Wizard vitalityWizard = new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(vitalityWizard);
    }

    @Test
    public void testBoostCorrectnessForBadBoyIntelligence()  {
        Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedBedBoyIntelligence = 65;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence();
        Assert.assertEquals(expectedBedBoyIntelligence, actual);

    }
    @Test
    public void testBoostCorrectnessForBadBoyKnowledge() {
        Wizard  knowledgeWizard= new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedBadBoyKnowledge =75;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge();
        Assert.assertEquals(expectedBadBoyKnowledge, actual);
    }
    @Test
    public void testBoostCorrectnessForBadBoyVitality() {
        Wizard  vitalityWizard= new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new BadBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedBadBoyVitality =90;
        int experimentalVitality=60;
        student.setVitality(experimentalVitality);
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedBadBoyVitality, actual);
    }


    @Test
    public void testBoostCorrectnessForNerdLadyIntelligence()  {
        Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdLady(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedNerdLadyIntelligence = 75;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence();
        Assert.assertEquals(expectedNerdLadyIntelligence, actual);

    }
    @Test
    public void testBoostCorrectnessForNerdLadyKnowledge() {
        Wizard  knowledgeWizard= new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdLady(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedNerdLadyKnowledge =65;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge();
        Assert.assertEquals(expectedNerdLadyKnowledge, actual);
    }
    @Test
    public void testBoostCorrectnessForNerdLadyVitality() {
        Wizard  vitalityWizard= new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdLady(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedVitality =90;
        int experimentalVitality=60;
        student.setVitality(expectedVitality);
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedVitality, actual);
    }


    @Test
    public void testBoostCorrectnessForNerdBoyIntelligence()  {
        Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedNerdBoyIntelligence = 75;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence();
        Assert.assertEquals(expectedNerdBoyIntelligence, actual);

    }
    @Test
    public void testBoostCorrectnessForNerdBoyKnowledge() {
        Wizard  knowledgeWizard= new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedNerdBoyKnowledge =65;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge();
        Assert.assertEquals(expectedNerdBoyKnowledge, actual);
    }
    @Test
    public void testBoostCorrectnessForNerdBoyVitality() {
        Wizard  vitalityWizard= new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new NerdBoy(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedNerdBoyVitality =90;
        int experimentalVitality=60;
        student.setVitality(experimentalVitality);
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedNerdBoyVitality, actual);
    }


    @Test
    public void testBoostCorrectnessForHotChickIntelligence()  {
        Wizard intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new HotChick(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedHotChickIntelligence = 65;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence();
        Assert.assertEquals(expectedHotChickIntelligence, actual);

    }
    @Test
    public void testBoostCorrectnessForHotChickKnowledge() {
        Wizard  knowledgeWizard= new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new HotChick(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedHotChickKnowledge =75;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge();
        Assert.assertEquals(expectedHotChickKnowledge, actual);
    }
    @Test
    public void testBoostCorrectnessForHotChickVitality() {
        Wizard  vitalityWizard= new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Student student=new HotChick(TEST_X_COORD,TEST_Y_COORD,TEST_NAME,TEST_FULL_NAME);
        int expectedVitality =90;
        int experimentalVitality=60;
        student.setVitality(expectedVitality);
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedVitality, actual);
    }


}
