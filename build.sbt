
val dottyVersion = dottyLatestNightlyBuild.get
val jarName = "dotty-taster-plugin.jar"

lazy val taster = project
  .in(file("."))
  .settings(
    name := "dotty-taster",
    scalaVersion := dottyVersion,
    libraryDependencies += "ch.epfl.lamp" %% "dotty" % dottyVersion,
    scalacOptions ++= Seq(
      "-Xplugin:dotty-taster-plugin.jar"
    ),
    test.in(assembly) := {},
    assemblyOutputPath.in(assembly) := baseDirectory.value / jarName
  )