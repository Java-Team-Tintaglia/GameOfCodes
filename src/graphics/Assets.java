package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage login;
    public static BufferedImage error;
    public static BufferedImage success;
    public static BufferedImage wall;
    public static BufferedImage wallTwo;
    public static BufferedImage wallToolbar;
    public static BufferedImage background;
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
        login=ImageLoader.loadingImage(ImageAlbum.LOGIN.getPath());
        error=ImageLoader.loadingImage(ImageAlbum.ERROR.getPath());
        success=ImageLoader.loadingImage(ImageAlbum.SUCCESS.getPath());
        wall = ImageLoader.loadingImage(ImageAlbum.WALL.getPath());
        wallTwo = ImageLoader.loadingImage(ImageAlbum.WALL_TWO.getPath());
        background = ImageLoader.loadingImage(ImageAlbum.BACKGROUND.getPath());
        wallToolbar = ImageLoader.loadingImage(ImageAlbum.WALL_TOOLBAR.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLOOR.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.MAIN_MENU.getPath());
        playerCustomization = ImageLoader.loadingImage(ImageAlbum.PLAYER_CUSTOMIZATION.getPath());
        selectPlayer = ImageLoader.loadingImage(ImageAlbum.SELECT_PLAYER.getPath());
        highScoresBackground = ImageLoader.loadingImage(ImageAlbum.HIGH_SCORES_BACKGROUND.getPath());
        diploma = ImageLoader.loadingImage(ImageAlbum.DIPLOMA.getPath());

        nerdLadyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NERD_LADY_PLAYER.getPath()));
        badBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.BAD_BOY_PLAYER.getPath()));
        hotChickPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.HOT_CHICK_PLAYER.getPath()));
        nerdBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NERD_BOY_PLAYER.getPath()));
        
        buttonStart = ImageLoader.loadingImage(ImageAlbum.BUTTON_START.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.BUTTON_SCORE.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.BUTTON_EXIT.getPath());
        buttonPlay = ImageLoader.loadingImage(ImageAlbum.BUTTON_PLAY.getPath());
        buttonBackToMenu = ImageLoader.loadingImage(ImageAlbum.BUTTON_BACK_TO_MENU.getPath());

        buttonEdit = ImageLoader.loadingImage(ImageAlbum.BUTTON_EDIT.getPath());
        buttonLogOut = ImageLoader.loadingImage(ImageAlbum.BUTTON_LOG_OUT.getPath());
        buttonLogIn = ImageLoader.loadingImage(ImageAlbum.BUTTON_LOG_IN.getPath());
        buttonOk = ImageLoader.loadingImage(ImageAlbum.BUTTON_OK.getPath());
        buttonProfile = ImageLoader.loadingImage(ImageAlbum.BUTTON_PROFILE.getPath());
        buttonRegister = ImageLoader.loadingImage(ImageAlbum.BUTTON_REGISTER.getPath());

        buttonBadBoy = ImageLoader.loadingImage(ImageAlbum.BAD_BOY_BUTTON.getPath());
        buttonHotChick = ImageLoader.loadingImage(ImageAlbum.HOT_CHICK_BUTTON.getPath());
        buttonNerdBoy = ImageLoader.loadingImage(ImageAlbum.NERD_BOY_BUTTON.getPath());
        buttonNerdLady = ImageLoader.loadingImage(ImageAlbum.NERD_LADY_BUTTON.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.JAVA_CHARACTER.getPath());
        cSharpCharacter = ImageLoader.loadingImage(ImageAlbum.CSHARP_CHARACTER.getPath());
        cPlusPlusCharacter = ImageLoader.loadingImage(ImageAlbum.CPLUSPLUS_CHARACTER.getPath());
        javaScriptCharacter = ImageLoader.loadingImage(ImageAlbum.JAVASCRIPT_CHARACTER.getPath());
        phpCharacter = ImageLoader.loadingImage(ImageAlbum.PHP_CHARACTER.getPath());

        wizard = ImageLoader.loadingImage(ImageAlbum.WIZARD.getPath());
        wizardBeer = ImageLoader.loadingImage(ImageAlbum.WIZARD_BEER.getPath());
        wizardCoffee = ImageLoader.loadingImage(ImageAlbum.WIZARD_COFFEE.getPath());
    }
}
