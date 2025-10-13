package edu.luc.cs.laufer.cs371.shapes

import com.typesafe.scalalogging.Logger
import Shape.*

object scale:
  private val logger = Logger("scale")

  def apply(s: Shape, factor: Double): Shape = {
    logger.debug(s"Scaling shape: $s by factor: $factor")
    s match {
      case Rectangle(width, height) =>
        val result = Rectangle((width * factor).round.toInt, (height * factor).round.toInt)
        logger.debug(s"Scaled Rectangle: $result")
        result
      case Ellipse(width, height) =>
        val result = Ellipse((width * factor).round.toInt, (height * factor).round.toInt)
        logger.debug(s"Scaled Ellipse: $result")
        result
      case Location(x, y, shape) =>
        val scaledShape = apply(shape, factor)
        val result = Location((x * factor).round.toInt, (y * factor).round.toInt, scaledShape)
        logger.debug(s"Scaled Location: $result")
        result
      case Group(shapes*) =>
        val scaledShapes = shapes.map(apply(_, factor))
        val result = Group(scaledShapes*)
        logger.debug(s"Scaled Group: $result")
        result
    }
  }

end scale
