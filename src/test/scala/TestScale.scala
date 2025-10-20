package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures._
import Shape._
import scale._

class TestScale extends AnyFunSuite:
  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      assert(scale(s, factor) == expected)

  testScale("scale rectangle", simpleRectangle, 2.0, Rectangle(160, 240))
  testScale("scale ellipse", simpleEllipse, 0.5, Ellipse(25, 15))
  testScale("scale location", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))
  testScale("scale basic group", basicGroup, 2.0, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("scale simple group", simpleGroup, 0.5, Group(Location(100, 50, Ellipse(25, 15)), Location(200, 150, Rectangle(50, 25))))

end TestScale
