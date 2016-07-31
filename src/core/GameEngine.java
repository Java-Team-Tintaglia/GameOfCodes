package core;

import eventhandler.KeyInput;
import eventhandler.MouseInput;
import graphics.Assets;
import graphics.Display;
import interfaces.State;
import repositories.StudentScoresRepository;
import repositories.UserRepository;
import states.MainMenuState;
import states.StateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

import authentication.AuthenticationProvider;
import constants.Common;
import constants.Coordinates;

public class GameEngine implements Runnable {
    private final String title;
    private boolean isRunning;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private KeyInput keyinput;
    private State mainMenuState;
    private MouseInput mouseInput;
    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;
    private StudentScoresRepository studentScoresRepository;

    public GameEngine(String title) {
        this.title = title;
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    public synchronized void stop() {
        if (this.isRunning) {
            try {
                this.isRunning = false;
                this.thread.join();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        this.init();

        final int fps = 30;
        final double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (this.isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                this.update();
                this.draw();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }

        this.stop();
    }

    private void update() {
        if(StateManager.getCurrentState()!= null) {
            StateManager.getCurrentState().update();
        }

    }

    private void draw() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();

        // -> START DRAWING
        this.graphics.clearRect(0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT);
        
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().draw(graphics);
        }
        
        // -> END DRAWING

        this.graphics.dispose();
        this.bufferStrategy.show();
    }

    private void init() {
        Assets.init();
        this.display = new Display(Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, this.title);      
        this.userRepository = new UserRepository();
        this.userRepository.load();
        this.studentScoresRepository = new StudentScoresRepository();
        
        this.authenticationProvider = new AuthenticationProvider(this.userRepository);
        this.keyinput = new KeyInput(this, this.display);
        this.mouseInput = new MouseInput(this.display, this.userRepository, this.authenticationProvider, this.studentScoresRepository);
        
        
        mainMenuState = new MainMenuState();
        StateManager.setCurrentState(mainMenuState);
    }
}
