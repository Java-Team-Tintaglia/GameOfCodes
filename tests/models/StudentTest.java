package models;

import java.util.List;
import enums.Grades;
import graphics.Assets;
import interfaces.ProgrammingLanguage;
import interfaces.Student;
import models.programmingLanguages.Java;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

    private static final String USERNAME = "username";
    private static final String FULL_NAME = "fullName";
    private static final int X_COORD = 100;
    private static final int Y_COORD = 100;

    private Student student;
    private ProgrammingLanguage language;

    @Before
    public void setUp() {
        Assets.init();
        this.student = new BadBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
        this.language = new Java(X_COORD, Y_COORD);
    }

    //region Constructor Tests
    @Test
    public void testBadBoyConstructorDifferentThanNull() {
        Student student = new BadBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testHotChickConstructorDifferentThanNull() {
        Student student = new HotChick(X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testNerdBoyConstructorDifferentThanNull() {
        Student student = new NerdBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testNerdLadyConstructorDifferentThanNull() {
        Student student = new NerdLady(X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }
    //endregion

    //region CalculateGrade Method Tests
    @Test
    public void testCalculateGradeShouldFailure() {
        this.student.setIntelligence(1);
        this.student.setVitality(1);
        this.student.setKnowledge(1);
        int actualGrade = this.student.calculateGrade();
        int expectedGrade = Grades.FAILURE.getGrade();
        Assert.assertEquals(expectedGrade, actualGrade);
    }

    @Test
    public void testCalculateGradeShouldExcellent() {
        this.student.setIntelligence(100);
        this.student.setVitality(100);
        this.student.setKnowledge(100);
        int actualGrade = this.student.calculateGrade();
        int expectedGrade = Grades.EXCELLENT.getGrade();
        Assert.assertEquals(expectedGrade, actualGrade);
    }
    //endregion

    @Test
    public void testAddScoreShouldIncreaseGradesSize() {
        int grade = 4;
        this.student.addScore(grade, this.language);
        List<Integer> languageGrades =
                this.student.getStudentGrades().get(language.getProgrammingLanguageType().getName());
        int expectedSize = 1;
        int actualGradeSize = languageGrades.size();
        Assert.assertEquals(expectedSize, actualGradeSize);
    }

    @Test
    public void testSetStatsShouldChangeValues() {
        int grade = 6;
        this.student.setStatsValues(grade, this.language);
        int knowledgePoints = 75;
        int vitalityPoints = 94;
        int expectedPoints = knowledgePoints + vitalityPoints;
        int actualPoints = this.student.getKnowledge() + this.student.getVitality();
        Assert.assertEquals(expectedPoints, actualPoints);
    }
}
