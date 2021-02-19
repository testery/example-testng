package testery.testng

import org.testng.Assert
import org.testng.Reporter
import org.testng.annotations.Test

class TestSomething {

    @Test(groups = ["pass", "nonWeb"])
    fun testSomeValue() {
        Reporter.log("Output from test")
        Assert.assertEquals(Something.someValue,"foo")
    }
}