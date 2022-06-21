package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DataSavingTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC30")
    @Severity(SeverityLevel.CRITICAL)
    public void DataSavingIntoFileOnArticleTitles() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
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
