package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height))
    case Ellipse(width, height) => Location(-width, -height, Rectangle(width * 2, height * 2))
    case Location(x, y, shape) =>
      val Location(u, v, Rectangle(w, h)) = apply(shape)
      Location(x + u, y + v, Rectangle(w, h))
    case Group(shapes*) =>
      val boxes = shapes.map(apply)
      val lefts = boxes.map(_.x)
      val tops = boxes.map(_.y)
      val rights = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
      val bottoms = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)
      val minLeft = lefts.min
      val minTop = tops.min
      val maxRight = rights.max
      val maxBottom = bottoms.max
      Location(minLeft, minTop, Rectangle(maxRight - minLeft, maxBottom - minTop))

end boundingBox
