package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage wall, floor;

    public static void init() {
        wall = ImageLoader.loadingImage(ImageAlbum.Wall.getPath());
        floor = ImageLoader.loadingImage(ImageAlbum.FLoor.getPath());
    }
}
