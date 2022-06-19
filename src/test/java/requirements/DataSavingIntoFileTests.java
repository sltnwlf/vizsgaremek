package requirements;

import base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DataSavingIntoFileTests extends TestBase {

    @RepeatedTest(3)
    @DisplayName("TC30")
    @Severity(SeverityLevel.NORMAL)
    public void DataSavingIntoFile() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnSeeAllPostButton();
        articles.savingPostTitlesIntoFile();
        String[] actual = utils.readFromFile("PostTitles.txt");
        String[] expected = {
                "Markdown Formatting Demo",
                "Designer Conference at Florida 2020",
                "Benjamin Franklins thoughts about new designers",
                "Designers thoughts about mobile UI",
                "How to become acreative designer",
                "New designers limitations",
                "Things you must know as a designer",
                "World's Most Famous App Developers and Designers",
                "You must know this before becoming a designer"};
        Assertions.assertArrayEquals(expected,actual);
    }

}
