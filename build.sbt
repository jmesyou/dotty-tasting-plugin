

val dottyVersion = "0.25.0-RC2"
val jarName = "dotty-taster-plugin.jar"
lazy val taster = project
  .in(file("."))
  .settings(
    name := "dotty-taster",
    scalaVersion := dottyVersion,
    libraryDependencies += "ch.epfl.lamp" %% "dotty" % dottyVersion,
    test.in(assembly) := {},
    assemblyOutputPath.in(assembly) := baseDirectory.value / jarName
  )