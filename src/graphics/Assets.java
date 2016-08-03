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
        login=ImageLoader.loadingImage(ImageAlbum.Login.getPath());
        error=ImageLoader.loadingImage(ImageAlbum.Error.getPath());
        success=ImageLoader.loadingImage(ImageAlbum.Success.getPath());
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        wallTwo = ImageLoader.loadingImage(ImageAlbum.Wall_Two.getPath());
        background = ImageLoader.loadingImage(ImageAlbum.Background.getPath());
        wallToolbar = ImageLoader.loadingImage(ImageAlbum.Wall_Toolbar.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.Main_Menu.getPath());
        playerCustomization = ImageLoader.loadingImage(ImageAlbum.Player_Customization.getPath());
        selectPlayer = ImageLoader.loadingImage(ImageAlbum.Select_Player.getPath());
        highScoresBackground = ImageLoader.loadingImage(ImageAlbum.High_Scores_Background.getPath());
        diploma = ImageLoader.loadingImage(ImageAlbum.Diploma.getPath());

        nerdLadyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.Nerd_Lady_Player.getPath()));
        badBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.Bad_Boy_Player.getPath()));
        hotChickPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.Hot_Chick_Player.getPath()));
        nerdBoyPlayer = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.Nerd_Boy_Player.getPath()));
        
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

        buttonBadBoy = ImageLoader.loadingImage(ImageAlbum.Bad_BoyButton.getPath());
        buttonHotChick = ImageLoader.loadingImage(ImageAlbum.Hot_Chick_Button.getPath());
        buttonNerdBoy = ImageLoader.loadingImage(ImageAlbum.Nerd_Boy_Button.getPath());
        buttonNerdLady = ImageLoader.loadingImage(ImageAlbum.Nerd_Lady_Button.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.Java_Character.getPath());
        cSharpCharacter = ImageLoader.loadingImage(ImageAlbum.Csharp_Character.getPath());
        cPlusPlusCharacter = ImageLoader.loadingImage(ImageAlbum.Cplusplus_Character.getPath());
        javaScriptCharacter = ImageLoader.loadingImage(ImageAlbum.Javascript_Character.getPath());
        phpCharacter = ImageLoader.loadingImage(ImageAlbum.PHP_Character.getPath());

        wizard = ImageLoader.loadingImage(ImageAlbum.Wizard.getPath());
        wizardBeer = ImageLoader.loadingImage(ImageAlbum.Wizard_Beer.getPath());
        wizardCoffee = ImageLoader.loadingImage(ImageAlbum.Wizard_Coffee.getPath());
    }
}
