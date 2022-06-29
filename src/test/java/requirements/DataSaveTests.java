package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DataSaveTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data save tests")
    @Description("Data saving into file on article titles test")
    @DisplayName("TC30")
    @Severity(SeverityLevel.CRITICAL)
    public void DataSavingIntoFileOnArticleTitles() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnSeeAllPost();
        blog.saveArticleTitlesIntoFile();
        String[] actual = utils.readFromFile("ArticleTitles.txt");
        String[] expected = {
                "1. article title: Markdown Formatting Demo",
                "2. article title: Designer Conference at Florida 2020",
                "3. article title: Benjamin Franklins thoughts about new designers",
                "4. article title: Designers thoughts about mobile UI",
                "5. article title: How to become acreative designer",
                "6. article title: New designers limitations",
                "7. article title: Things you must know as a designer",
                "8. article title: World's Most Famous App Developers and Designers",
                "9. article title: You must know this before becoming a designer"};
        Assertions.assertArrayEquals(expected,actual);
    }

}
