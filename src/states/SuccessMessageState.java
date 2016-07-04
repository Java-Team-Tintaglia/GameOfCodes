package states;

import graphics.Assets;
import utils.Constants;

import java.awt.*;
import java.util.StringTokenizer;

public class SuccessMessageState extends State { 
	
	private State nextState;
    private String message;

    public static models.Button okButton = new models.Button(700, 350, Assets.buttonOk);

    public SuccessMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {
        int messagePositionX = 220;
        int messagePositionY = 190;

        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);

        Font titleFont = new Font("Arial", Font.BOLD, 35);
        graphics.setFont(titleFont);
        graphics.setColor(Color.green);
        graphics.drawString("Success", 220, 90);

        StringTokenizer tokens = new StringTokenizer(this.message, " ");
        graphics.setFont(new Font("Arial", Font.PLAIN, 25));

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
