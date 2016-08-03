package enums;

public enum  ImageAlbum {
    Wall("/wall.png"),
    Wall_Two("/wall_half02.png"),
    Login("/login.jpg"),
    Error("/error.jpg"),
    Success("/success.jpg"),
    Wall_Toolbar("/wallToolbar.png"),
    Background("/background.png"),
    FLoor("/floor.png"),
    Player_Customization("/playerCustomization.png"),
    High_Scores_Background("/highScoresImage.png"),
    Select_Player("/selectPlayer.png"),
    Nerd_Boy_Player("/nerds.png"),
    Nerd_Lady_Player("/nerdLady.png"),
    Hot_Chick_Player("/hotChick.png"),
    Bad_Boy_Player("/badBoy.png"),
    Bad_BoyButton("/buttonBadBoy.png"),
    Hot_Chick_Button("/buttonHotChick.png"),
    Nerd_Boy_Button("/buttonNerdBoy.png"),
    Nerd_Lady_Button("/buttonNerdLady.png"),
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
    Main_Menu("/frontPage.png"),
    Java_Character("/Languages/java.png"),
    Csharp_Character("/Languages/csharp.png"),
    Cplusplus_Character("/Languages/cplusplus.png"),
    PHP_Character("/Languages/php.png"),
    Javascript_Character("/Languages/javascript.png"),
    Wizard("/wizard.png"),
    Wizard_Beer("/wizard_beer.png"),
    Wizard_Coffee("/wizard_coffee.png"),
    Diploma("/diploma.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
