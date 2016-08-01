package repositories;

import constants.Common;
import constants.Messages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StudentScoresRepository {
    public static Map<String, List<Integer>> studentsScore
            = new TreeMap<>();

    public void saveToFile(String studentName, Map<String, List<Integer>> studentsGrades) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Common.SCORES_FILE_PATH, true), true)) {
            StringBuilder save = new StringBuilder();
            save.append(studentName + " ");
            for (Entry<String, List<Integer>> studentGrades : studentsGrades.entrySet()) {
                String subject = studentGrades.getKey();

                save.append(subject + ":");

                for (Integer grade : studentsGrades.get(subject)) {
                    save.append(grade + ",");
                }

                save.append(";");
            }

            writer.print(save.toString());
            writer.println();
            
        } catch (IOException exception) {
            System.err.println(Messages.FILE_WRITING_FAILURE);
            exception.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Common.SCORES_FILE_PATH))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] token = line.split(" ");
                String studentName = token[0];
                String[] studentGrades = token[1].split(";");

                if (!studentsScore.containsKey(studentName)) {
                    studentsScore.put(studentName, new ArrayList<>());
                }

                for (int i = 0; i < studentGrades.length; i++) {
                    String[] subjectGrades = studentGrades[i].split(":");

                    String[] grades = subjectGrades[1].trim().split(",");


                    for (int j = 0; j < grades.length; j++) {
                        Integer grade = Integer.parseInt(grades[j]);
                        studentsScore.get(studentName).add(grade);
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }

    }

    public Map<String, ArrayList<Integer>> getAllGradesBySubject(String username) {
        TreeMap<String, ArrayList<Integer>> grades = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Common.SCORES_FILE_PATH))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] token = line.split(" ");
                String studentName = token[0];
                String[] studentGrades = token[1].split(";");
                if (studentName.equals(username)) {
                    for (int i = 0; i < studentGrades.length; i++) {
                        String[] subjectGrades = studentGrades[i].split(":");
                        String subject = subjectGrades[0];
                        String[] userGrades = subjectGrades[1].trim().split(",");
                        if (!grades.containsKey(subject)) {
                            grades.put(subject, new ArrayList<>());
                        }
                        for (int j = 0; j < userGrades.length; j++) {
                            Integer grade = Integer.parseInt(userGrades[j]);
                            grades.get(subject).add(grade);
                        }
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }
        return grades;
    }
}


