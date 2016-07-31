package states;

import graphics.Assets;
import interfaces.State;
import models.ButtonImpl;
import interfaces.Button;

import java.awt.*;
import java.util.StringTokenizer;

import constants.Coordinates;
import constants.Fonts;

public class SuccessMessageState implements State {
	private State nextState;
    private String message;

    public static Button okButton = new ButtonImpl(
    										Coordinates.MESSAGE_STATE_OK_BUTTON_X,
    										Coordinates.MESSAGE_STATE_OK_BUTTON_Y, 
    										Assets.buttonOk);

    public SuccessMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.success, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
        Font titleFont = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(titleFont);
        graphics.setColor(Color.black);

        StringTokenizer tokens = new StringTokenizer(this.message, " ");

        String line = "";
        int lineLength = 0;
        int messagePositionY = 400;
        int maxLettersPerRow = 40;
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            if (lineLength + word.length() > maxLettersPerRow) {
                lineLength = 0;
                graphics.drawString(line, Coordinates.MESSAGE_STATE_MESSAGE_POSITION_X, messagePositionY);
                line = "";
                messagePositionY += Coordinates.MESSAGE_STATE_MESSAGE_OFFSET;
            }
            
            line += (word + " ");
            lineLength += word.length();
        }
        graphics.drawString(line, Coordinates.MESSAGE_STATE_MESSAGE_POSITION_X, messagePositionY);

        okButton.draw(graphics);
    }

    @Override
    public void update() {}

	public State getNextState() {
		return nextState;
	}  
}
