import org.scalatest.FlatSpec

/**
 * Created by indix on 23/2/15.
 */
class RemoteControlTest extends FlatSpec {
  "RemoteControl" should "work properly for one key up" in {
    val minChannel = 1
    val maxChannel = 20
    val numberOfBlockedChannels = 2
    val blockedChannels = List(18, 19)
    val numberOfChannelsToView = 5
    val channelsToView = List(15,14,17,1,7)


  }
}
