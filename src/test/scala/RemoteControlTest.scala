import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
 * Created by indix on 23/2/15.
 */
class RemoteControlTest extends FlatSpec {
  "RemoteControl" should "check for upKey fucntion to work properly" in {
    val remote = new RemoteControl(1, 25, List(), List(5,10,15,20,25))
    val output = remote.upKeyMoves(5, 10)
    output should be(5)
  }

  it should "check for down function to work properly" in {
    val remote = new RemoteControl(1, 25, List(), List(5,10,15,20,25))
    val output = remote.downKeyMoves(10, 5)
    output should be(5)
  }

  it should "check for keyButton function to work properly" in {
    val remote = new RemoteControl(1, 25, List(), List(5,10,15,20,25))
    val output1 = remote.numberKeyMoves(1)
    output1 should be(1)

    val output2 = remote.numberKeyMoves(100)
    output2 should be(3)
  }

  it should "check for backButton function to work properly" in {
    val remote = new RemoteControl(1, 25, List(), List(5,10,15,20,25))
    val output1 = remote.backButton(5, 5)
    output1 should be(1)

    val output2 = remote.backButton(5, 6)
    output2 should be(10000)
  }
}
