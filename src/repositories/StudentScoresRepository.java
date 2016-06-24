package repositories;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import utils.Constants;

public class StudentScoresRepository {
    public static TreeMap<String, List<Integer>> studentsScore
            = new TreeMap<>();

    public static void saveToFile(String studentName, Map<String, List<Integer>> studentsGrades){
    	 try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.SCORES_FILE_PATH, true), true)) { 	
        	StringBuilder save = new StringBuilder();
        	save.append(studentName + " ");
        	for(Entry<String, List<Integer>> studentGrades : studentsGrades.entrySet()){
                String subject = studentGrades.getKey();
               
                save.append(subject + ":");
                
                for (Integer grade : studentsGrades.get(subject)) {
					save.append(grade + ",");
				}
                
                save.append(";");
        	}
        	
        	writer.print(save.toString());
        	writer.println();

        } catch (IOException exception){
            System.err.println("Cannot write to file");
            exception.printStackTrace();
        }
    }

    public static void readFromFile() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.SCORES_FILE_PATH))){
            String line = bufferedReader.readLine();
            
            while (line != null) {
            	String[] token = line.split(" ");
                String studentName = token[0];
                String[] studentGrades = token[1].split(";");

                if(!studentsScore.containsKey(studentName)){
                    studentsScore.put(studentName, new ArrayList<>());
                }

                for(int i = 0; i < studentGrades.length; i ++){
                	String[] subjectGrades = studentGrades[i].split(":");

                	String[] grades = subjectGrades[1].trim().split(",");
                    
                    
                    for(int j = 0; j < grades.length; j++){
                         Integer grade = Integer.parseInt(grades[j]);
                         studentsScore.get(studentName).add(grade);
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException exception){
            System.err.println("Cannot read file.");
            exception.printStackTrace();
        }

    }
}


