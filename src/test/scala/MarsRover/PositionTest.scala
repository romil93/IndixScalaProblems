package MarsRover

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

/**
 * Created by romil93 on 24/02/15.
 */
class PositionTest extends FlatSpec {
  "PostionTest" should "make sure the position is not out of the grid" in {
    val pos = new Position(1, 1, North)

    pos.outOfTheGridChecker(2,2,10,10) should be(2,2)

    val exception = intercept[Exception] {
      pos.outOfTheGridChecker(10,10,9,9)
    }

    exception.getMessage should be("The Mars Rover has gone off the grid")
  }

  it should "make sure it returns the current values in the returnCurrentValue" in {
    val pos = new Position(1,1,North)
    pos.returnCurrentValues() should be((1,1,North))
  }
}
