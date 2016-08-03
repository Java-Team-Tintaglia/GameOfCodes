package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentScoresRepository {
    void saveToFile(String studentName, Map<String, List<Integer>> studentsGrades);
    void readFromFile();
    Map<String, ArrayList<Integer>> getAllGradesBySubject(String username);
}
