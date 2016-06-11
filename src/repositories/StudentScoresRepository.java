package repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import static utils.Constants.SAVE_FILE_PATH;

public class StudentScoresRepository {
    public static TreeMap<String, LinkedHashMap<String, List<Integer>>> students
            = new TreeMap<String, LinkedHashMap<String, List<Integer>>>();

    public static void saveToFile(String name, String subject, List<Integer> grades){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))){
            StringBuilder save = new StringBuilder();
            save.append(name + " " + subject);
            for(int grade : grades){
                save.append(" " + grade);
            }
            bufferedWriter.write(save.toString() + "\n");
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
                String subject = data[1];
                List<Integer> grades = new ArrayList<>();
                for(int i = 2; i < data.length; i++){
                    grades.add(Integer.parseInt(data[i]));
                }

                if(!students.containsKey(studentName)){
                    students.put(studentName, new LinkedHashMap<String, List<Integer>>());
                }

                if(!(students.get(studentName).containsKey(subject))){
                    students.get(studentName).put(subject, new ArrayList<>());
                }

                for(Integer grade : grades){
                    students.get(studentName).get(subject).add(grade);
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException exception){
            System.err.println("Cannot read file.");
            exception.printStackTrace();
        }

    }
}


