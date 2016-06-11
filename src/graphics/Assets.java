package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall;
    public static BufferedImage floor;
    public static BufferedImage mainMenu;

    public static SpriteSheet nerdLady;
    public static SpriteSheet badBoy;
    public static SpriteSheet hotChick;
    public static SpriteSheet nerdBoy;
    public static SpriteSheet nerds;
    public static BufferedImage computerCharacter;

    public static BufferedImage buttonPlay;
    public static BufferedImage buttonScore;
    public static BufferedImage buttonExit;
    
    public static BufferedImage javaCharacter;

    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        mainMenu = ImageLoader.loadingImage(ImageAlbum.MainMenu.getPath());

        nerdLady = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLady.getPath()));
        badBoy = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.BadBoy.getPath()));
        hotChick = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.HotChick.getPath()));
        nerdBoy = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdBoy.getPath()));
        nerds = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NERDS.getPath()));

        buttonPlay = ImageLoader.loadingImage(ImageAlbum.Button_Play.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.Button_Score.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.Button_Exit.getPath());

        javaCharacter = ImageLoader.loadingImage(ImageAlbum.JavaCharacter.getPath());

    }
}
