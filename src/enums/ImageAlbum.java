package enums;

public enum  ImageAlbum {

    Wall("/wall.png"),
    FLoor("/floor.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
