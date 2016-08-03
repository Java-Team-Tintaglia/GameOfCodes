package enums;

public enum  ImageAlbum {
    WALL("/wall.png"),
    WALL_TWO("/wall_half02.png"),
    LOGIN("/login.jpg"),
    ERROR("/error.jpg"),
    SUCCESS("/success.jpg"),
    WALL_TOOLBAR("/wallToolbar.png"),
    BACKGROUND("/background.png"),
    FLOOR("/floor.png"),
    PLAYER_CUSTOMIZATION("/playerCustomization.png"),
    HIGH_SCORES_BACKGROUND("/highScoresImage.png"),
    SELECT_PLAYER("/selectPlayer.png"),
    NERD_BOY_PLAYER("/nerds.png"),
    NERD_LADY_PLAYER("/nerdLady.png"),
    HOT_CHICK_PLAYER("/hotChick.png"),
    BAD_BOY_PLAYER("/badBoy.png"),
    BAD_BOY_BUTTON("/buttonBadBoy.png"),
    HOT_CHICK_BUTTON("/buttonHotChick.png"),
    NERD_BOY_BUTTON("/buttonNerdBoy.png"),
    NERD_LADY_BUTTON("/buttonNerdLady.png"),
    BUTTON_START("/buttonStart.png"),
    BUTTON_SCORE("/buttonScore.png"),
    BUTTON_PLAY("/buttonPlay.png"),
    BUTTON_EXIT("/buttonExit.png"),
    BUTTON_BACK_TO_MENU("/backToMenu.png"),
    BUTTON_EDIT("/buttonEdit.png"),
    BUTTON_LOG_OUT("/buttonLogOut.png"),
    BUTTON_LOG_IN("/buttonLogIn.png"),
    BUTTON_OK("/buttonOk.png"),
    BUTTON_PROFILE("/buttonProfile.png"),
    BUTTON_REGISTER("/buttonRegister.png"),
    MAIN_MENU("/frontPage.png"),
    JAVA_CHARACTER("/Languages/java.png"),
    CSHARP_CHARACTER("/Languages/csharp.png"),
    CPLUSPLUS_CHARACTER("/Languages/cplusplus.png"),
    PHP_CHARACTER("/Languages/php.png"),
    JAVASCRIPT_CHARACTER("/Languages/javascript.png"),
    WIZARD("/wizard.png"),
    WIZARD_BEER("/wizard_beer.png"),
    WIZARD_COFFEE("/wizard_coffee.png"),
    DIPLOMA("/diploma.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
