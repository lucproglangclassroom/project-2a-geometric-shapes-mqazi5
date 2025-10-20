name := "shapes-oo-scala"

version := "0.4"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"     % "0.30.0",
  "org.log4s" %% "log4s" % "1.10.0",
  "org.slf4j" % "slf4j-simple" % "1.7.30",
  "org.scalameta" %% "munit" % "1.0.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)
