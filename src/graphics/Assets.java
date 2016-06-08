package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall;
    public static BufferedImage floor;
    public static SpriteSheet nerdLady;

    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
        
        nerdLady = new SpriteSheet(ImageLoader.loadingImage(ImageAlbum.NerdLady.getPath()));
    }
}
