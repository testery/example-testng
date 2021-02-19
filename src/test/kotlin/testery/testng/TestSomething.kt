package testery.testng

import org.testng.Assert
import org.testng.annotations.Test

class TestSomething {

    @Test(groups = ["pass"])
    fun testSomeValue() {
        Assert.assertEquals(Something.someValue,"foo")
    }
}