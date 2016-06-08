package models;

/**
 * Created by soki on 08-Jun-16.
 */
public abstract class Student extends GameObject{

    private String name;
    private int intelligence;
    private int knowledge;
    private int vitality;


    public Student(String name, int intelligence, int knowledge, int vitality) {
        super(name,intelligence,knowledge,vitality);
    }


}
