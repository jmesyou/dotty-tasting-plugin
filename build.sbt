val dottyVersion = "0.25.0-RC2"

lazy val taster = project
  .in(file("."))
  .settings(
    name := "dotty-taster",
    scalaVersion := dottyVersion,
    libraryDependencies += "ch.epfl.lamp" %% "dotty" % dottyVersion
  )