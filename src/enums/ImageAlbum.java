package enums;

public enum  ImageAlbum {

    Background("/background.jpg");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
