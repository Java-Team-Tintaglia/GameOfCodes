package states;

import graphics.Assets;
import utils.Constants;

import java.awt.*;
import java.util.StringTokenizer;

public class SuccessMessageState extends State { 
	
	private State nextState;
    private String message;

    public static models.Button okButton = new models.Button(400, 310, Assets.buttonOk);

    public SuccessMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {
        int messagePositionX = 270;
        int messagePositionY = 190;

        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);

        Font titleFont = new Font("Arial", Font.BOLD, 35);
        graphics.setFont(titleFont);
        graphics.setColor(Color.green);
        graphics.drawString("Success", 370, 90);

        StringTokenizer tokens = new StringTokenizer(this.message, " ");
        StringBuilder output = new StringBuilder(this.message.length());
        int lineLen = 0;
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            if (lineLen + word.length() > 23) {
                output.append("\n");
                lineLen = 0;
            }
            output.append(word + " ");
            lineLen += word.length();
        }

        Font messageFont = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(messageFont);
        graphics.drawString(output.toString(), messagePositionX, messagePositionY);

        okButton.draw(graphics);
    }

    @Override
    public void update() {
    }

	public State getNextState() {
		return nextState;
	}
    
}
