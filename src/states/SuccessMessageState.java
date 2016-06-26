package states;

import repositories.UserRepository;

import java.awt.*;

public class SuccessMessageState extends State{
    private String message;

    public SuccessMessageState(UserRepository userRepository, String message) {
        super(userRepository);
        this.message = message;
    }

    @Override
    public void draw(Graphics graphics) {
        int messagePositionX = 650;
        int messagePositionY = 250;

        Font font = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(font);
        graphics.setColor(Color.green);
        graphics.drawString(this.message, messagePositionX, messagePositionY);
    }

    @Override
    public void update() {

    }
}
