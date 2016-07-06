package enums;

public enum  ImageAlbum {
    Wall("/wall.png"),
    WallTwo("/wall_half02.png"),
    Login("/login.jpg"),
    Error("/error.jpg"),
    Success("/success.jpg"),
    WallToolbar("/wallToolbar.png"),
    Background("/background.png"),
    FLoor("/floor.png"),
    PlayerCustomization("/playerCustomization.png"),
    HighScoresBackground("/highScoresImage.png"),
    SelectPlayer("/selectPlayer.png"),
    NerdBoyPlayer("/nerds.png"),
    NerdLadyPlayer("/nerdLady.png"),
    HotChickPlayer("/hotChick.png"),
    BadBoyPlayer("/badBoy.png"),
    BadBoyButton("/buttonBadBoy.png"),
    HotChickButton("/buttonHotChick.png"),
    NerdBoyButton("/buttonNerdBoy.png"),
    NerdLadyButton("/buttonNerdLady.png"),
    Button_Start("/buttonStart.png"),
    Button_Score("/buttonScore.png"),
    Button_Play("/buttonPlay.png"),
    Button_Exit("/buttonExit.png"),
    Button_BackToMenu("/backToMenu.png"),
    Button_Edit("/buttonEdit.png"),
    Button_LogOut("/buttonLogOut.png"),
    Button_LogIn("/buttonLogIn.png"),
    Button_Ok("/buttonOk.png"),
    Button_Profile("/buttonProfile.png"),
    Button_Register("/buttonRegister.png"),
    MainMenu("/frontPage.png"),
    JavaCharacter("/Languages/java.png"),
    CsharpCharacter("/Languages/csharp.png"),
    CplusplusCharacter("/Languages/cplusplus.png"),
    PHPCharacter("/Languages/php.png"),
    JavascriptCharacter("/Languages/javascript.png"),
    Wizard("/wizard.png"),
    WizardBeer("/wizard_beer.png"),
    WizardCoffee("/wizard_coffee.png"),
    Diploma("/diploma.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
