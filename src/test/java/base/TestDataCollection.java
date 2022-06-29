package base;

/*******************************************************************************************************************
    Külön osztály az összes, a tesztekben felhasznált tesztadat tárolására, a static kulcsszó segítségével pedig
  meghívhatóak az osztály, változókba mentett tesztadatai az egyes tesztosztályokban a class-ra való hivatkozással.
 ******************************************************************************************************************/
public class TestDataCollection {

    /*******************************************************************************************************************
                                 Tesztadatok a regisztrációhoz és a bejelentkezéshez.
     ******************************************************************************************************************/
    public final static String regLogUsername = "Felhasznalonev";
    public final static String regLogUsernameFromFile = "Felhasznalonev03";
    public final static String regLogPassword = "Jelszo01";
    public final static String regLogPasswordFromFile = "Jelszo03";

    public final static String regLogDescription = "Egy rovid leiras.";

    /*******************************************************************************************************************
                                       Tesztadatok a contact page teszteléséhez.
     ******************************************************************************************************************/
    public final static String contactName = "Nev";
    public final static String contactMessage = "Egy rovid uzenet.";

    /*******************************************************************************************************************
                                        Tesztadatok profile page teszteléséhez.
     ******************************************************************************************************************/
    public final static String profileName1 = "Nev1";
    public final static String profileName2 = "Nev2";
    public final static String profileBio1 = "Bio1";
    public final static String profileBio2 = "Bio2";
    public final static String profilePhone1 = "+36201234567";
    public final static String profilePhone2 = "+36301234567";

    /*******************************************************************************************************************
                                       Általánosabban felhasználható tesztadatok.
     ******************************************************************************************************************/
    public final static String email = "teszt@email.hu";
    public final static String emailNothingAfterAt = "teszt@";
    public final static String emailNothingBeforeAt = "@email.hu";
    public final static String emailWithoutAt = "email.hu";
    public final static String emailWithoutDot = "teszt@email";
    public final static String empty = "";

}
