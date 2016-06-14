package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall;
    public static BufferedImage floor;
    public static BufferedImage mainMenu;
    public static BufferedImage playerCustomization;
    public static BufferedImage selectPlayer;

    public static SpriteSheet nerdLady;
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
    
    public static BufferedImage wizard;

    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.MainMenu.getPath());
        playerCustomization = ImageLoader.loadingImage(ImageAlbum.PlayerCustomization.getPath());
        selectPlayer = ImageLoader.loadingImage(ImageAlbum.SelectPlayer.getPath());

        nerdLady = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLady.getPath()));
        badBoy = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.BadBoy.getPath()));
        hotChick = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.HotChick.getPath()));
        nerdBoy = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdBoy.getPath()));
        nerds = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NERDS.getPath()));

        buttonStart = ImageLoader.loadingImage(ImageAlbum.Button_Start.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.Button_Score.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.Button_Exit.getPath());

        buttonPlay = ImageLoader.loadingImage(ImageAlbum.Button_Play.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.JavaCharacter.getPath());
        csharpCharacter = ImageLoader.loadingImage(ImageAlbum.CsharpCharacter.getPath());
        cplusplusCharacter = ImageLoader.loadingImage(ImageAlbum.CplusplusCharacter.getPath());
        javascriptCharacter = ImageLoader.loadingImage(ImageAlbum.JavascriptCharacter.getPath());
        phpCharacter = ImageLoader.loadingImage(ImageAlbum.PHPCharacter.getPath());
        wizard = ImageLoader.loadingImage(ImageAlbum.Wizard.getPath());
        diploma = ImageLoader.loadingImage(ImageAlbum.Diploma.getPath());

    }
}
