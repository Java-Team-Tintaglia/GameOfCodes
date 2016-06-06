package graphics;

import enums.ImageAlbum;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage background;

    public static void init() {
        background =  ImageLoader.loadingImage(ImageAlbum.Background.getPath());
    }
}
