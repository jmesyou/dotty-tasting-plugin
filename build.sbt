val dottyVersion = dottyLatestNightlyBuild.get 

lazy val root = project
  .in(file("."))
  .settings(
    organization := "ca.uwaterloo.plg",
    name := "dotty-taster-plugin",
    version := "1.0",
    scalaVersion := dottyVersion,
    libraryDependencies ++= Seq(
      "ch.epfl.lamp" %% "dotty" % dottyVersion,
    ),
    scalacOptions ++= Seq()
  )
