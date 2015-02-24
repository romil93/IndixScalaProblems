package MarsRover

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
 * Created by romil93 on 24/02/15.
 */
class MarsRoverV2Test extends FlatSpec {
  "MatsRoverV2" should "move appropriate to the directions" in {
    val rover = new MarsRoverV2
    rover.move(1,2,North) should be(1,3)

    rover.move(1,3, South) should be(1, 2)

    rover.move(10, 10, East) should be(11,10)

    rover.move(11,10, West) should be(10,10)
  }

  it should "rotate appropriate to the rotation asked for" in {
    val rover = new MarsRoverV2
    rover.rotate(North, "L") should be(West)

    rover.rotate(East, "R") should be(South)

    rover.rotate(South, "L") should be(East)

    rover.rotate(West, "R") should be(North)
  }

}
