package repositories;

import constants.Common;
import constants.Messages;
import interfaces.Readable;
import interfaces.StudentScoresRepository;
import interfaces.Writeable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StudentScoresRepositoryImpl implements StudentScoresRepository {
    public static Map<String, List<Integer>> studentsScore
            = new TreeMap<>();

    private Readable reader;
    private Writeable writer;
    
    public StudentScoresRepositoryImpl(Readable reader, Writeable writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void saveToFile(String studentUsername, Map<String, List<Integer>> studentsGrades) {
            StringBuilder save = new StringBuilder();
            save.append(studentUsername + " ");
            for (Entry<String, List<Integer>> studentGrades : studentsGrades.entrySet()) {
                String subject = studentGrades.getKey();

                save.append(subject + ":");

                for (Integer grade : studentsGrades.get(subject)) {
                    save.append(grade + ",");
                }

                save.append(";");
            }
            
	        try {
	        	this.writer.write(Common.SCORES_FILE_PATH, save.toString());
	
	        } catch (IOException exception) {
	            System.err.println(Messages.FILE_WRITING_FAILURE);
	            exception.printStackTrace();
	        }
    }

    public void readFromFile() {
    	try {
    		String line = this.reader.readLine();
            while (line != null) {
                String[] token = line.split(" ");
                String studentUsername = token[0];
                String[] studentGrades = token[1].split(";");

                if (!studentsScore.containsKey(studentUsername)) {
                    studentsScore.put(studentUsername, new ArrayList<>());
                }

                for (int i = 0; i < studentGrades.length; i++) {
                    String[] subjectGrades = studentGrades[i].split(":");

                    String[] grades = subjectGrades[1].trim().split(",");


                    for (int j = 0; j < grades.length; j++) {
                        Integer grade = Integer.parseInt(grades[j]);
                        studentsScore.get(studentUsername).add(grade);
                    }
                }

                line = this.reader.readLine();
            }
            
            this.reader.close();
		} catch (IOException exception) {
           System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }
    }


    public Map<String, ArrayList<Integer>> getAllGradesBySubject(String username) {
        TreeMap<String, ArrayList<Integer>> grades = new TreeMap<>();
        try {
        String line = this.reader.readLine();
            while (line != null) {
                String[] token = line.split(" ");
                String studentUsername = token[0];
                String[] studentGrades = token[1].split(";");
                if (studentUsername.equals(username)) {
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
                line = this.reader.readLine();
            }
            
            this.reader.close();
        } catch (IOException exception) {
            System.err.println(Messages.FILE_READING_FAILURE);
            exception.printStackTrace();
        }
        return grades;
    }
}


