package RemoteControl

/**
 * Created by indix on 23/2/15.
 */

class RemoteControl(minChannel: Int, maxChannel: Int, blockedChannels: List[Int]) {

  def upKeyMoves(fromChannelInUp: Int, toChannelInUp: Int, count: Int = 0): Int = {
    if (fromChannelInUp == toChannelInUp) {
      count
    } else if (fromChannelInUp == maxChannel) {
      upKeyMoves(minChannel, toChannelInUp, count + 1)
    } else if (blockedChannels.contains(fromChannelInUp)){
      upKeyMoves(fromChannelInUp + 1, toChannelInUp, count)
    } else{
      upKeyMoves(fromChannelInUp + 1, toChannelInUp, count + 1)
    }

  }

  def downKeyMoves(fromChannelInDown: Int, toChannelInDown: Int, count: Int = 0): Int = {
    if (fromChannelInDown == toChannelInDown) {
      count
    } else if (fromChannelInDown == minChannel) {
      downKeyMoves(maxChannel, toChannelInDown, count + 1)
    } else if (blockedChannels.contains(fromChannelInDown)){
      downKeyMoves(fromChannelInDown - 1, toChannelInDown, count)
    } else {
      downKeyMoves(fromChannelInDown - 1, toChannelInDown, count + 1)
    }
  }

  def numberKeyMoves(toChannelInNumberKey: Int, count: Int = 1): Int = {
    if (toChannelInNumberKey/10 < 1 && toChannelInNumberKey%10 == toChannelInNumberKey){
      count
    }else{
      numberKeyMoves(toChannelInNumberKey/10, count + 1)
    }
  }

  def backButton(previousChannelInBack: Int, toChannelInBack: Int): Int = {
    if (previousChannelInBack != -1 && previousChannelInBack == toChannelInBack){
      1
    }else{
      10000
    }
  }

  def movesCalculator(previousChannelInMoves: Int, fromChannel: Int, toChannel: Int): Int = {
    val upMoves = upKeyMoves(fromChannel, toChannel)
    val downMoves = downKeyMoves(fromChannel, toChannel)
    val numberKeyMove = numberKeyMoves(toChannel)
    val backMove = backButton(previousChannelInMoves, toChannel)

    val keys = List(upMoves, downMoves, numberKeyMove, backMove).min
    keys
  }

  def keyPresses(channelsToView: List[Int], previousChannel: Int = -1, mainCount: Int = 0): Int = {
    channelsToView match {
      case Nil                  => throw new IllegalArgumentException("Invalid input")
      case x :: Nil             => throw new IllegalArgumentException("Invalid input")
      case from :: to :: Nil    => {
        val count = movesCalculator(previousChannel, from, to)
        mainCount + count
      }
      case from :: to :: rest => {
        val count = movesCalculator(previousChannel, from, to)
        keyPresses(to :: rest, from, mainCount + count)
      }
    }
  }
}
