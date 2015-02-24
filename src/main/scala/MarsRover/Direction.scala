package MarsRover

/**
 * Created by romil93 on 24/02/15.
 */

trait Direction {

  val name: String
  def rotateLeft(): Direction
  def rotateRight(): Direction
  def moveAhead(curX: Int, curY: Int): (Int, Int)
}


case object North extends Direction {
  override val name: String = "N"

  override def rotateLeft(): Direction = West

  override def rotateRight(): Direction = East

  override def moveAhead(curX: Int, curY: Int): (Int, Int) = {
    (curX, curY + 1)
  }
}

case object South extends Direction {
  override val name: String = "S"

  override def rotateLeft(): Direction = East

  override def rotateRight(): Direction = West

  override def moveAhead(curX: Int, curY: Int): (Int, Int) = {
    (curX, curY - 1)
  }
}

case object East extends Direction {
  override val name: String = "E"

  override def rotateLeft(): Direction = North

  override def rotateRight(): Direction = South

  override def moveAhead(curX: Int, curY: Int): (Int, Int) = {
    (curX + 1, curY)
  }
}

case object West extends Direction {
  override val name: String = "W"

  override def rotateLeft(): Direction = South

  override def rotateRight(): Direction = North

  override def moveAhead(curX: Int, curY: Int): (Int, Int) = {
    (curX - 1, curY)
  }
}