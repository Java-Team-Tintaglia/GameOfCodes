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
    private static final int TEST_INTELIGENCE = 65;
    private static final int EXPECTED_BADBOY_KNOWLEDGE = 75;
    private static final int EXPECTED_BADBOY_VITALITY = 90;
    private static final int ACTUAL_BADBOY_VITALITY = 60;
    private Wizard intelligenceWizard;
    private Wizard knowledgeWizard;
    private Wizard vitalityWizard;
    private Student student;


    @Before
    public void setUp() {
        Assets.init();
        this.student = new BadBoy(TEST_X_COORD, TEST_Y_COORD, "TEST", "TEST");
        this.intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        this.knowledgeWizard=new KnowledgeWizard(TEST_X_COORD,TEST_Y_COORD);
        this.vitalityWizard=new VitalityWizard(TEST_X_COORD,TEST_Y_COORD);

    }


    @Test
    public void constructorIntelligenceWizard_Check_Correctness() {
        this.intelligenceWizard = new IntelligenceWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(this.intelligenceWizard);
    }
    @Test
    public void constructorKnowledgeWizard_Check_Correctness() {
        this.knowledgeWizard = new KnowledgeWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(this.knowledgeWizard);
    }
    @Test
    public void constructorVitalityWizard_Check_Correctness() {
        this.vitalityWizard = new VitalityWizard(TEST_X_COORD, TEST_Y_COORD);
        Assert.assertNotNull(this.vitalityWizard);
    }


    //
    @Test
    public void testBoost_Intelligence() throws Exception {
        int expectedBedBoyIntelligence = TEST_INTELIGENCE;
        this.intelligenceWizard.boost(this.student);
        int actual = this.student.getIntelligence();
        Assert.assertEquals(expectedBedBoyIntelligence, actual);

    }
    @Test
    public  void testBoost_Knowledge(){
        int expectedBadBoyKnowledge = EXPECTED_BADBOY_KNOWLEDGE;
        this.knowledgeWizard.boost(this.student);
        int actual = this.student.getKnowledge();
        Assert.assertEquals(expectedBadBoyKnowledge, actual);
    }

    @Test
    public  void testBoost_Vitality(){
        int expectedVitality=EXPECTED_BADBOY_VITALITY;
        this.student.setVitality(ACTUAL_BADBOY_VITALITY);
        this.vitalityWizard.boost(this.student);
        int actual=this.student.getVitality();
        Assert.assertEquals(expectedVitality, actual);
    }
}
