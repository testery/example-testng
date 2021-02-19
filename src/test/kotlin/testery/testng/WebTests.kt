package testery.testng

import org.testng.annotations.Test
import org.testng.Assert
import testery.testng.Helpers.createBrowser
import testery.testng.Helpers.takeScreenshot


class WebTests {
    val browser = createBrowser()

    @Test(groups = ["pass"])
    fun webSiteName() {
        browser.get("http://www.testery.io/");

        browser.takeScreenshot("testery-homepage")
        Assert.assertEquals(browser.title,"Testery - Cloud-based continuous testing platform")
    }

    @Test(groups = ["fail"])
    fun badWebSiteName() {
        browser.get("http://www.testery.io/");

        Assert.assertEquals(browser.title,"Bad Name");
    }

}