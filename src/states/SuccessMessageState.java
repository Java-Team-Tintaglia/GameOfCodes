package states;

import graphics.Assets;
import utils.Constants;

import java.awt.*;
import java.util.StringTokenizer;

public class SuccessMessageState extends State {
	private State nextState;
    private String message;

    private static int okButtonXCoord = 450;
    private static int okButtonYCoord = 500;
    private int titleFontSize = 20;
    private int messageFontSize = 22;

    public static models.Button okButton = new models.Button(okButtonXCoord,
            okButtonYCoord, Assets.buttonOk);

    public SuccessMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {
        int messagePositionX = 250;
        int messagePositionY = 400;

        graphics.drawImage(Assets.success, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);


        Font titleFont = new Font("Arial", Font.BOLD, titleFontSize);
        graphics.setFont(titleFont);
        graphics.setColor(Color.black);


        StringTokenizer tokens = new StringTokenizer(this.message, " ");
        graphics.setFont(new Font("Arial", Font.BOLD, messageFontSize));

        String line = "";
        int lineLen = 0;
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            if (lineLen + word.length() > 40) {
                lineLen = 0;
                graphics.drawString(line, messagePositionX, messagePositionY);
                line = "";
                messagePositionY += 30;
            }
            line += (word + " ");
            lineLen += word.length();
        }
        graphics.drawString(line, messagePositionX, messagePositionY);

        okButton.draw(graphics);
    }

    @Override
    public void update() {
    }

	public State getNextState() {
		return nextState;
	}
    
}
