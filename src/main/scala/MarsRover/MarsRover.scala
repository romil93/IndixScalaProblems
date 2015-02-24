package MarsRover

/**
 * Created by romil93 on 24/02/15.
 */

class MarsRover(maxX: Int, maxY: Int) {
  def move(curX: Int, curY: Int, direction: Direction): (Int, Int) = {
    direction.name match {
      case "N" => {
        val (x,y) = North.moveAhead(curX, curY)
        outOfTheGridChecker(x, y)
      }
      case "S" => {
        val (x,y) = South.moveAhead(curX, curY)
        outOfTheGridChecker(x, y)
      }
      case "E" => {
        val (x,y) = East.moveAhead(curX, curY)
        outOfTheGridChecker(x, y)
      }
      case "W" => {
        val (x,y) = West.moveAhead(curX, curY)
        outOfTheGridChecker(x, y)
      }
    }
  }

  def outOfTheGridChecker(x: Int,y: Int): (Int, Int) ={
    (x,y) match {
      case (a, b) if a < 0 || b < 0 || a>maxX || b>maxY  => throw new Exception("The Mars Rover has gone off the grid")
      case _ => (x, y)
    }
  }

  def rotate(direction: Direction, input: String): Direction = {
    input match {
      case "L" => {
        direction.rotateLeft()
      }
      case "R" => {
        direction.rotateRight()
      }
    }
  }

  def manage(curX: Int, curY: Int, direction: Direction, input: String): (Int, Int, String) = {
    val inputList = input.split("").toList
    recursiveManage(curX, curY, direction, inputList)
  }

  def recursiveManage(curX: Int, curY: Int, direction: Direction, inputList: List[String]): (Int, Int, String) = {
    inputList match {
      case Nil => (curX, curY, direction.name)
      case "L" :: rest => {
        val dir: Direction = rotate(direction, "L")
        recursiveManage(curX, curY, dir, rest)
      }
      case "R" :: rest => {
        val dir: Direction = rotate(direction, "R")
        recursiveManage(curX, curY, dir, rest)
      }
      case "M" :: rest => {
        val (x,y) = move(curX, curY, direction)
        recursiveManage(x, y, direction, rest)
      }
      case _ => throw new IllegalArgumentException("Invalid input string")
    }
  }
}


//class MarsRover(maxX: Int, maxY: Int, minX: Int = 0, minY: Int = 0) {
//  def move(startX: Int, startY: Int, direction: String, rest: List[String]) = {
//    direction match {
//      case "N" => actionOnInput(startX, startY + 1, direction, rest)
//      case "S" => actionOnInput(startX, startY - 1, direction, rest)
//      case "E" => actionOnInput(startX + 1, startY, direction, rest)
//      case "W" => actionOnInput(startX - 1, startY, direction, rest)
//      case _   => throw new IllegalArgumentException("Invalid Direction only N, S, W and E allowed.")
//    }
//  }
//
//  def rotate(startX: Int, startY: Int, direction: String, input: String, rest: List[String]) = {
//    input match {
//      case "L" => {
//        direction match {
//          case "N" => actionOnInput(startX, startY, "W", rest)
//          case "S" => actionOnInput(startX, startY, "E", rest)
//          case "E" => actionOnInput(startX, startY, "N", rest)
//          case "W" => actionOnInput(startX, startY, "S", rest)
//          case _   => throw new IllegalArgumentException("Invalid Direction only N, S, W and E allowed.")
//        }
//      }
//      case "R" => {
//        direction match {
//          case "N" => actionOnInput(startX, startY, "E", rest)
//          case "S" => actionOnInput(startX, startY, "W", rest)
//          case "E" => actionOnInput(startX, startY, "S", rest)
//          case "W" => actionOnInput(startX, startY, "N", rest)
//          case _   => throw new IllegalArgumentException("Invalid Direction only N, S, W and E allowed.")
//        }
//      }
//    }
//  }
//
//  def actionOnInput(startX: Int, startY: Int, direction: String, moves: List[String]) = {
//    moves match {
//      case Nil => println(startX, startY, direction)
//      case input :: rest => {
//        action(input, rest)
//      }
//    }
//
//    def action(input: String, rest: List[String]) = {
//      input match {
//        case "L" | "R" => rotate(startX, startY, direction, input, rest)
//        case "M"       => move(startX, startY, direction, rest)
//        case _         => throw new IllegalArgumentException("Invalid input. Only L,R and M are allowed")
//      }
//    }
//  }
//}
