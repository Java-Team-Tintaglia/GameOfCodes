package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage frontPage;
    public static BufferedImage wall;
    public static BufferedImage floor;

    public static BufferedImage buttonPlay;
    public static BufferedImage buttonScore;
    public static BufferedImage buttonExit;
    
    public static SpriteSheet nerdLady;

    public static void init() {
        frontPage = ImageLoader.loadingImage(ImageAlbum.First_Page.getPath());
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());

        buttonPlay = ImageLoader.loadingImage(ImageAlbum.Button_Play.getPath());
        buttonScore = ImageLoader.loadingImage(ImageAlbum.Button_Score.getPath());
        buttonExit = ImageLoader.loadingImage(ImageAlbum.Button_Exit.getPath());
        
        nerdLady = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLady.getPath()));
    }
}
