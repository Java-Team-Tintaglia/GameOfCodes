package models;

/**
 * Created by soki on 08-Jun-16.
 */
public abstract class Student extends GameObject{
    private int x;
    private int y;
    private String name;
    private int intelligence;
    private int knowledge;
    private int vitality;

    public Student(int x, int y, int x1, int y1, String name, int intelligence, int knowledge, int vitality) {
        super(x, y);
        x = x1;
        y = y1;
        this.name = name;
        this.intelligence = intelligence;
        this.knowledge = knowledge;
        this.vitality = vitality;
    }
}
