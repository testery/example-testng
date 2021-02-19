package testery.testng

import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File
import java.util.*
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.Reporter

object Helpers {
    private val screenShotDir =  File("screenshots")

    init {
        screenShotDir.mkdirs()
    }

    fun createBrowser(): WebDriver {
        val options = ChromeOptions()

        if(System.getenv("IS_TESTERY") == "true") {
            options.addArguments(System.getenv("TESTERY_CHROME_ARGS").split(";"))
        } else {
            options.addArguments("--headless", "--start-maximized", "--window-size=1920,1080")
        }

        return ChromeDriver(options)
    }

    fun WebDriver.takeScreenshot(name: String = UUID.randomUUID().toString()) {
        val src = (this as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        val fileName = "$name.png"
        val dest = File(screenShotDir, fileName)
        dest.writeBytes(src.readBytes())
        Reporter.log("Stored screenshot: $fileName")
    }
}