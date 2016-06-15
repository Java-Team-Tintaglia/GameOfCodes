package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall;
    public static BufferedImage floor;
    public static BufferedImage mainMenu;
    public static BufferedImage playerCustomization;
    public static BufferedImage selectPlayer;
    public static BufferedImage highScoresBackground;

    public static BufferedImage buttonBadBoy;
    public static BufferedImage buttonHotChick;
    public static BufferedImage buttonNerdBoy;
    public static BufferedImage buttonNerdLady;

    public static SpriteSheet nerdladyplayer;
    public static SpriteSheet hotchikplayer;
    public static SpriteSheet badboyplayer;
    public static SpriteSheet nerdBoyplayer;
    
    public static SpriteSheet badBoy;
    public static SpriteSheet hotChick;
    public static SpriteSheet nerdBoy;
    public static SpriteSheet nerds;
    
    public static BufferedImage javaCharacter;
    public static BufferedImage phpCharacter;
    public static BufferedImage csharpCharacter;
    public static BufferedImage javascriptCharacter;
    public static BufferedImage cplusplusCharacter;
    public static BufferedImage diploma;

    public static BufferedImage buttonStart;
    public static BufferedImage buttonScore;
    public static BufferedImage buttonExit;
    public static BufferedImage buttonPlay;
    public static BufferedImage buttonBackToMenu;

    public static BufferedImage wizard;
    public static BufferedImage wizardBeer;
    public static BufferedImage wizardCoffee;


    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.MainMenu.getPath());
        playerCustomization = ImageLoader.loadingImage(ImageAlbum.PlayerCustomization.getPath());
        selectPlayer = ImageLoader.loadingImage(ImageAlbum.SelectPlayer.getPath());
        highScoresBackground = ImageLoader.loadingImage(ImageAlbum.HighScoresBackground.getPath());

        nerdladyplayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLadyPlayer.getPath()));
        badboyplayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.BadBoyPlayer.getPath()));
        hotchikplayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.HotChickPlayer.getPath()));
        nerdBoy = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdBoyPlayer.getPath()));
        
        
        buttonStart = ImageLoader.loadingImage(ImageAlbum.Button_Start.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.Button_Score.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.Button_Exit.getPath());
        buttonPlay = ImageLoader.loadingImage(ImageAlbum.Button_Play.getPath());
        buttonBackToMenu = ImageLoader.loadingImage(ImageAlbum.Button_BackToMenu.getPath());
        
        buttonBadBoy = ImageLoader.loadingImage(ImageAlbum.BadBoyButton.getPath());
        buttonHotChick = ImageLoader.loadingImage(ImageAlbum.HotChickButton.getPath());
        buttonNerdBoy = ImageLoader.loadingImage(ImageAlbum.NerdBoyButton.getPath());
        buttonNerdLady = ImageLoader.loadingImage(ImageAlbum.NerdLadyButton.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.JavaCharacter.getPath());
        csharpCharacter = ImageLoader.loadingImage(ImageAlbum.CsharpCharacter.getPath());
        cplusplusCharacter = ImageLoader.loadingImage(ImageAlbum.CplusplusCharacter.getPath());
        javascriptCharacter = ImageLoader.loadingImage(ImageAlbum.JavascriptCharacter.getPath());
        phpCharacter = ImageLoader.loadingImage(ImageAlbum.PHPCharacter.getPath());

        wizard = ImageLoader.loadingImage(ImageAlbum.Wizard.getPath());
        wizardBeer = ImageLoader.loadingImage(ImageAlbum.WizardBeer.getPath());
        wizardCoffee = ImageLoader.loadingImage(ImageAlbum.WizardCoffee.getPath());

        diploma = ImageLoader.loadingImage(ImageAlbum.Diploma.getPath());

    }
}
