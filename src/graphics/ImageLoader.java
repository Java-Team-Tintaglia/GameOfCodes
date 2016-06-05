package graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {





    public class ImageLoader {

        public static BufferedImage loadingImage(String path) {
            try {
                return ImageIO.read(ImageLoader.class.getResource(path));

            } catch (IOException e) {
                System.exit(1);
            }
            return null;
        }
    }
}
