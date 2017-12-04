name := "isabelle-remix"
version := "0.1.0"
scalaVersion := "2.12.4"
scalaVersion in ThisBuild := "2.12.4"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
disablePlugins(PlayLayoutPlugin)

routesGenerator := InjectedRoutesGenerator

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += guice
libraryDependencies += "org.tukaani" % "xz" % "1.6"

// We do not need documentation thanks to noweb
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false
