package repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import enums.ProgrammingLanguageType;
import graphics.Assets;
import interfaces.Readable;
import interfaces.StudentScoresRepository;
import interfaces.Writeable;

@RunWith(MockitoJUnitRunner.class)
public class StudentScoresRepositoryTest {

	private static final String USERNAME = "USERNAME";
	
	@Mock
	private Readable mockedReader;
	
	@Mock
	private Writeable mockedWriter;
	
	private StudentScoresRepository studentScoresRepository;
	
	@Before
	public void setUp() {
		Assets.init();
		this.studentScoresRepository = new StudentScoresRepositoryImpl(mockedReader, mockedWriter);
		String line = USERNAME + " Java:6,6,;";
		try {
			Mockito.when(this.mockedReader.readLine()).thenReturn(line).thenReturn(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllGradesBySubjectShouldLoadGrades() {
		Map<String, ArrayList<Integer>> grades = this.studentScoresRepository.getAllGradesBySubject(USERNAME);
		int actualSize = grades.get(ProgrammingLanguageType.JAVA.getName()).size();
		int expectedSize = 2;
		Assert.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void testGetAllGradesBySubjectShouldNotBeEmpty() {
		Map<String, ArrayList<Integer>> grades = this.studentScoresRepository.getAllGradesBySubject(USERNAME);
		int actualSize = grades.size();
		int expectedSize = 1;
		Assert.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void testAllGradesShouldNotBeEmpty() {
		this.studentScoresRepository.readFromFile();
		int actualSize = StudentScoresRepositoryImpl.studentsScore.size();
		int expectedSize = 1;
		Assert.assertEquals(expectedSize, actualSize);
	}
	
}
