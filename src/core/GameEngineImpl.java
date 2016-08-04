package core;

import eventhandler.KeyInputImpl;
import eventhandler.MouseInputImpl;
import graphics.Assets;
import graphics.Display;
import interfaces.AuthenticationProvider;
import interfaces.GameEngine;
import interfaces.Readable;
import interfaces.State;
import interfaces.StudentScoresRepository;
import interfaces.UserRepository;
import interfaces.Writeable;
import io.InputReader;
import io.OutputWriter;
import repositories.StudentScoresRepositoryImpl;
import repositories.UserRepositoryImpl;
import states.MainMenuState;
import states.StateManager;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;

import authentication.AuthenticationProviderImpl;
import constants.Common;
import constants.Coordinates;

public class GameEngineImpl implements GameEngine {
    private final String title;
    private boolean isRunning;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private KeyListener keyinput;
    private State mainMenuState;
    private MouseListener mouseInput;
    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;
    private StudentScoresRepository studentScoresRepository;

    public GameEngineImpl(String title) {
        this.title = title;
    }

    @Override
    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    @Override
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
        
        Readable scoresReader = null;
        Readable usersReader = null;
		try {
			scoresReader = new InputReader(Common.SCORES_FILE_PATH);
			usersReader = new InputReader(Common.USERS_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        Writeable scoresWriter = new OutputWriter();
        Writeable usersWriter = new OutputWriter();
        
        this.display = new Display(Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, this.title);      
        this.authenticationProvider = new AuthenticationProviderImpl();
        this.userRepository = new UserRepositoryImpl(this.authenticationProvider, usersReader, usersWriter);
        this.authenticationProvider.setUserRepository(this.userRepository);
        this.userRepository.load();
        this.studentScoresRepository = new StudentScoresRepositoryImpl(scoresReader, scoresWriter);    
        this.keyinput = new KeyInputImpl(this.display);
        this.mouseInput = new MouseInputImpl(this.display, this.userRepository, this.authenticationProvider, this.studentScoresRepository);  
        mainMenuState = new MainMenuState(this.authenticationProvider);
        StateManager.setCurrentState(this.mainMenuState);
    }
}
