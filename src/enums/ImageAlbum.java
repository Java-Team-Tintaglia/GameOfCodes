package enums;

public enum  ImageAlbum {

    Wall("/wall.png"),
    FLoor("/floor.png"),
	NerdLady("/nerd_lady.png"),
    Button_Play("buttonPlay.png"),
    Button_Score("buttonScore.png"),
    Button_Exit("buttonExit.png"),
    First_Page("frontPage.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
