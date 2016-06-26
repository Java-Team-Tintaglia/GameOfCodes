package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall;
    public static BufferedImage wallToolbar;
    public static BufferedImage floor;
    public static BufferedImage mainMenu;
    public static BufferedImage playerCustomization;
    public static BufferedImage selectPlayer;
    public static BufferedImage highScoresBackground;
    public static BufferedImage diploma;

    public static BufferedImage buttonBadBoy;
    public static BufferedImage buttonHotChick;
    public static BufferedImage buttonNerdBoy;
    public static BufferedImage buttonNerdLady;

    public static SpriteSheet nerdLadyPlayer;
    public static SpriteSheet hotChickPlayer;
    public static SpriteSheet badBoyPlayer;
    public static SpriteSheet nerdBoyPlayer;
    
    public static BufferedImage javaCharacter;
    public static BufferedImage phpCharacter;
    public static BufferedImage cSharpCharacter;
    public static BufferedImage javaScriptCharacter;
    public static BufferedImage cPlusPlusCharacter;  

    public static BufferedImage buttonStart;
    public static BufferedImage buttonScore;
    public static BufferedImage buttonExit;
    public static BufferedImage buttonPlay;
    public static BufferedImage buttonBackToMenu;

    public static BufferedImage buttonEdit;
    public static BufferedImage buttonLogOut;
    public static BufferedImage buttonLogIn;
    public static BufferedImage buttonOk;
    public static BufferedImage buttonProfile;
    public static BufferedImage buttonRegister;

    public static BufferedImage wizard;
    public static BufferedImage wizardBeer;
    public static BufferedImage wizardCoffee;

    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        wallToolbar = ImageLoader.loadingImage(ImageAlbum.WallToolbar.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.MainMenu.getPath());
        playerCustomization = ImageLoader.loadingImage(ImageAlbum.PlayerCustomization.getPath());
        selectPlayer = ImageLoader.loadingImage(ImageAlbum.SelectPlayer.getPath());
        highScoresBackground = ImageLoader.loadingImage(ImageAlbum.HighScoresBackground.getPath());
        diploma = ImageLoader.loadingImage(ImageAlbum.Diploma.getPath());
        
        nerdLadyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLadyPlayer.getPath()));
        badBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.BadBoyPlayer.getPath()));
        hotChickPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.HotChickPlayer.getPath()));
        nerdBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdBoyPlayer.getPath()));
        
        buttonStart = ImageLoader.loadingImage(ImageAlbum.Button_Start.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.Button_Score.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.Button_Exit.getPath());
        buttonPlay = ImageLoader.loadingImage(ImageAlbum.Button_Play.getPath());
        buttonBackToMenu = ImageLoader.loadingImage(ImageAlbum.Button_BackToMenu.getPath());

        buttonEdit = ImageLoader.loadingImage(ImageAlbum.Button_Edit.getPath());
        buttonLogOut = ImageLoader.loadingImage(ImageAlbum.Button_LogOut.getPath());
        buttonLogIn = ImageLoader.loadingImage(ImageAlbum.Button_LogIn.getPath());
        buttonOk = ImageLoader.loadingImage(ImageAlbum.Button_Ok.getPath());
        buttonProfile = ImageLoader.loadingImage(ImageAlbum.Button_Profile.getPath());
        buttonRegister = ImageLoader.loadingImage(ImageAlbum.Button_Register.getPath());

        buttonBadBoy = ImageLoader.loadingImage(ImageAlbum.BadBoyButton.getPath());
        buttonHotChick = ImageLoader.loadingImage(ImageAlbum.HotChickButton.getPath());
        buttonNerdBoy = ImageLoader.loadingImage(ImageAlbum.NerdBoyButton.getPath());
        buttonNerdLady = ImageLoader.loadingImage(ImageAlbum.NerdLadyButton.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.JavaCharacter.getPath());
        cSharpCharacter = ImageLoader.loadingImage(ImageAlbum.CsharpCharacter.getPath());
        cPlusPlusCharacter = ImageLoader.loadingImage(ImageAlbum.CplusplusCharacter.getPath());
        javaScriptCharacter = ImageLoader.loadingImage(ImageAlbum.JavascriptCharacter.getPath());
        phpCharacter = ImageLoader.loadingImage(ImageAlbum.PHPCharacter.getPath());

        wizard = ImageLoader.loadingImage(ImageAlbum.Wizard.getPath());
        wizardBeer = ImageLoader.loadingImage(ImageAlbum.WizardBeer.getPath());
        wizardCoffee = ImageLoader.loadingImage(ImageAlbum.WizardCoffee.getPath());
    }
}
