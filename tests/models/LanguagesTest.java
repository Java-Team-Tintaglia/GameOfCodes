package models;

import graphics.Assets;
import interfaces.ProgrammingLanguage;
import models.programmingLanguages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LanguagesTest {
    private static final int X_COORD = 100;
    private static final int Y_COORD = 100;

    @Before
    public void setUp(){
        Assets.init();
    }
    @Test
    public  void constructorCPlusPlusShouldNotBeNull(){
        ProgrammingLanguage language=new CPlusPlus(X_COORD,Y_COORD);
        Assert.assertNotNull(language);
    }

    @Test
    public  void constructorCSharpShouldNotBeNull(){
        ProgrammingLanguage language=new CSharp(X_COORD,Y_COORD);
        Assert.assertNotNull(language);
    }
    @Test
    public  void constructorJavaShouldNotBeNull(){
        ProgrammingLanguage language=new Java(X_COORD,Y_COORD);
        Assert.assertNotNull(language);
    }
    @Test
    public  void constructorJavaScriptShouldNotBeNull(){
        ProgrammingLanguage language=new JavaScript(X_COORD,Y_COORD);
        Assert.assertNotNull(language);
    }
    @Test
    public  void constructorPhpShouldNotBeNull(){
        ProgrammingLanguage language=new Php(X_COORD,Y_COORD);
        Assert.assertNotNull(language);
    }
}
