package models.students;

import graphics.Assets;
import utils.Constants;

public class NerdBoy extends Student {


    public NerdBoy(int x, int y, String name) {
        super(x, y, Assets.nerds, Constants.NERDBOY_WIDTH, Constants.NERDBOY_HEIGHT, name, 70, 80, 100);
    }


}
