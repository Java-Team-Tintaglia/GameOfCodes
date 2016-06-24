package models.students;

import graphics.Assets;

public class NerdBoy extends Student {

    public static final int NERDBOY_WIDTH = 50;
    public static final int NERDBOY_HEIGHT = 49;

    public NerdBoy(String firstName, String surname, String username, String password) {
        super(Assets.nerdBoyPlayer, NERDBOY_WIDTH, NERDBOY_HEIGHT, 70, 80, 100, firstName, surname, username, password);
    }
}
