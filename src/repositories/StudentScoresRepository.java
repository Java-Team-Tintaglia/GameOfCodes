package repositories;

import java.io.*;
import java.util.*;

import static utils.Constants.SAVE_FILE_PATH;

public class StudentScoresRepository {
    public static TreeMap<String, LinkedHashMap<String, List<Integer>>> studentsScore
            = new TreeMap<>();

    // da priema MAP i da se foreachva i zapisva
    // Done
    public static void saveToFile(TreeMap<String, LinkedHashMap<String, List<Integer>>> students){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))){
            for(Map.Entry<String, LinkedHashMap<String, List<Integer>>> student : students.entrySet()){
                String name = student.getKey();
                StringBuilder save = new StringBuilder();

                save.append(name + " ");
                for(Map.Entry<String, List<Integer>> grades : student.getValue().entrySet()){
                    String subject = grades.getKey();
                    save.append(subject + ",");
                    List<Integer> gradesList = grades.getValue();
                    for(int i = 0; i < gradesList.size(); i++){
                        if(i == gradesList.size() - 1){
                            save.append(gradesList.get(i) + ";");
                        } else {
                            save.append(gradesList.get(i) + ",");
                        }
                    }
                }
                bufferedWriter.write(save.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException exception){
            System.err.println("Cannot write to file");
            exception.printStackTrace();
        }
    }

    public static void readFromFile(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(SAVE_FILE_PATH))){
            String line = bufferedReader.readLine();
            String[] data;

            while(line != null){
                data = line.split(" ");
                String studentName = data[0];
                String[] subjectsAndGrades = data[1].split(";");

                if(!studentsScore.containsKey(studentName)){
                    studentsScore.put(studentName, new LinkedHashMap<String, List<Integer>>());
                }

                for(int i = 0; i < subjectsAndGrades.length; i++){
                    String[] tokens = subjectsAndGrades[i].split(",");
                    String subject = tokens[0];

                    if(!(studentsScore.get(studentName).containsKey(subject))){
                        studentsScore.get(studentName).put(subject, new ArrayList<>());
                        for(int j = 1; j < tokens.length; j++){
                            int grade = Integer.parseInt(tokens[j]);
                            studentsScore.get(studentName).get(subject).add(grade);
                        }
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


