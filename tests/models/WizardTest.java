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

    private static final int X_COORD = 100;
    private static final int Y_COORD = 100;
    private static final String TEST_NAME = "TEST";
    private static final String TEST_FULL_NAME = "TEST";

    private Student student;
    @Before
    public void setUp() {
        Assets.init();
        this.student= new BadBoy(X_COORD, Y_COORD,TEST_NAME,TEST_FULL_NAME);


    }

    @Test
    public void constructorIntelligenceWizardShouldNotBeNull() {
        Wizard intelligenceWizard = new IntelligenceWizard(X_COORD, Y_COORD);
        Assert.assertNotNull(intelligenceWizard);
    }
    @Test
    public void constructorKnowledgeWizardShouldNotBeNull() {
        Wizard knowledgeWizard = new KnowledgeWizard(X_COORD, Y_COORD);
        Assert.assertNotNull(knowledgeWizard);
    }
    @Test
    public void constructorVitalityWizardShouldNotBeNull() {
        Wizard vitalityWizard = new VitalityWizard(X_COORD, Y_COORD);
        Assert.assertNotNull(vitalityWizard);
    }
    @Test
    public void testBoostIntelligentWizard() {

        Wizard intelligenceWizard = new IntelligenceWizard(X_COORD, Y_COORD);
        int expectedBedBoyIntelligence = this.student.getIntelligence() + 5;
        intelligenceWizard.boost(student);
        int actual = student.getIntelligence() ;
        Assert.assertEquals(expectedBedBoyIntelligence, actual);

    }
    @Test
    public void testBoostKnowledgeWizards() {
        Wizard knowledgeWizard = new KnowledgeWizard(X_COORD, Y_COORD);
        int expectedBadBoyKnowledge = this.student.getKnowledge() + 5;
        knowledgeWizard.boost(student);
        int actual = student.getKnowledge() ;
        Assert.assertEquals(expectedBadBoyKnowledge, actual);
    }
    @Test
    public void testBoostVitalityWizards() {

        Wizard vitalityWizard = new VitalityWizard(X_COORD, Y_COORD);
        int expectedBadBoyVitality = this.student.getVitality();
        vitalityWizard.boost(student);
        int actual = student.getVitality();
        Assert.assertEquals(expectedBadBoyVitality, actual);
    }


}
