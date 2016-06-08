package states;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import graphics.Assets;
import utils.Constants;

import java.awt.*;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.black);

        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.drawString(stringBuilger.toString(), 100, 100);


    }

    @Override
    public void update() {

    }
}
