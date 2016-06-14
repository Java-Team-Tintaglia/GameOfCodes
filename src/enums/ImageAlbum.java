package enums;

public enum  ImageAlbum {
    Wall("/wall.png"),
    FLoor("/floor.png"),
    PlayerCustomization("/playerCustomization.png"),
    HighScoresBackground("/highScoresImage.png"),
    SelectPlayer("/selectPlayer.png"),
    BadBoy("/StudentModels/badboy4.jpg"),
	NerdLady("/nerd_lady.png"),
    HotChick("/StudentModels/hotgirl4.jpg"),
    NerdBoy("/StudentModels/nerdBoy2.jpg"),
    BadBoyButton("/badBoy.png"),
    HotChickButton("/hotChick.png"),
    NerdBoyButton("/nerdBoy.png"),
    NerdLadyButton("/nerdLady.png"),
    Button_Start("/buttonStart.png"),
    Button_Score("/buttonScore.png"),
    Button_Play("/buttonPlay.png"),
    Button_Exit("/buttonExit.png"),
    Button_BackToMenu("/backToMenu.png"),
    MainMenu("/frontPage.png"),
    NERDS("/nerds.png"),
    JavaCharacter("/Languages/java.png"),
    CsharpCharacter("/Languages/csharp.png"),
    CplusplusCharacter("/Languages/cplusplus.png"),
    PHPCharacter("/Languages/php.png"),
    JavascriptCharacter("/Languages/javascript.png"),
    Wizard("/wizard.png"),
    Diploma("/diploma.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
