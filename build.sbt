name := "shapes-oo-scala"

version := "0.4"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"     % "0.30.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "org.slf4j" % "slf4j-simple" % "2.0.7",
  "org.scalameta" %% "munit" % "1.0.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)
