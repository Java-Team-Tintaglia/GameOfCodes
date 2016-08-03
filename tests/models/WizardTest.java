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
    private static final String USERNAME = "TEST";
    private static final String FULL_NAME = "TEST";

    private Student student;
    
    @Before
    public void setUp() {
        Assets.init();
        this.student= new BadBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
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
        int expectedIntelligence = 65;
        intelligenceWizard.boost(student);
        int actualIntelligence = student.getIntelligence() ;
        Assert.assertEquals(expectedIntelligence, actualIntelligence);
    }
    
    @Test
    public void testBoostKnowledgeWizards() {
        Wizard knowledgeWizard = new KnowledgeWizard(X_COORD, Y_COORD);
        int expectedKnowledge = 75;
        knowledgeWizard.boost(student);
        int actualKnowledge = student.getKnowledge() ;
        Assert.assertEquals(expectedKnowledge, actualKnowledge);
    }
    
    @Test
    public void testBoostVitalityWizards() {
        Wizard vitalityWizard = new VitalityWizard(X_COORD, Y_COORD);
        this.student.setVitality(50);
        int expectedVitality = 80;
        vitalityWizard.boost(student);
        int actualVitality = student.getVitality();
        Assert.assertEquals(expectedVitality, actualVitality);
    }
    
    @Test
    public void testMaxVitalityPointsShouldNotChanged() {
        Wizard vitalityWizard = new VitalityWizard(X_COORD, Y_COORD);
        int expectedVitality = 100;
        vitalityWizard.boost(student);
        int actualVitality = student.getVitality();
        Assert.assertEquals(expectedVitality, actualVitality);
    }
}
