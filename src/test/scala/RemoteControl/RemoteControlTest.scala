package RemoteControl

import RemoteControl.RemoteControl
import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
 * Created by indix on 23/2/15.
 */
class RemoteControlTest extends FlatSpec {
  "RemoteControl" should "check for upKey fucntion to work properly" in {
    val remote = new RemoteControl(1, 25, List())
    val output = remote.upKeyMoves(5, 10)
    output should be(5)
  }

  it should "check for down function to work properly" in {
    val remote = new RemoteControl(1, 25, List())
    val output = remote.downKeyMoves(10, 5)
    output should be(5)
  }

  it should "check for keyButton function to work properly" in {
    val remote = new RemoteControl(1, 25, List())
    val output1 = remote.numberKeyMoves(1)
    output1 should be(1)

    val output2 = remote.numberKeyMoves(100)
    output2 should be(3)
  }

  it should "check for backButton function to work properly" in {
    val remote = new RemoteControl(1, 25, List())
    val output1 = remote.backButton(5, 5)
    output1 should be(1)

    val output2 = remote.backButton(5, 6)
    output2 should be(10000)
  }

  it should "not work for just one channel to watch" in {
    val remote = new RemoteControl(1,25,List())
    val message = intercept[IllegalArgumentException]{
      remote.keyPresses(List(5))
    }

    message.getMessage should be("Invalid input")
  }

  it should "return 1 for calling adjacent channels" in {
    val remote = new RemoteControl(1,25,List())
    val output = remote.keyPresses(List(5,6))

    output should be(1)
  }

  it should "work for the test case 1 in the question" in {
    val remote = new RemoteControl(1,20, List(18,19))
    val output = remote.keyPresses(List(15, 14, 17, 1, 17))

    output should be(5)
  }

  it should "work for test case 2 in the question" in {
    val remote = new RemoteControl(103,108, List(104))
    val output = remote.keyPresses(List(105,106,107,103,105))

    output should be(5)
  }

  it should "work for test case 3 in the question" in {
    val remote = new RemoteControl(1, 100, List(78,79,80,3))
    val output = remote.keyPresses(List(10,13,13,100,99,98,77,81))

    output should be(10)
  }

  it should "work for test case 4 in the question" in {
    val remote = new RemoteControl(1, 200, List())
    val output = remote.keyPresses(List(1, 100, 1, 101))

    output should be(7)
  }
}
