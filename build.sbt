name := "isabelle-remix"
version := "0.1.0"
scalaVersion := "2.12.1"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
disablePlugins(PlayLayoutPlugin)

routesGenerator := InjectedRoutesGenerator

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += guice

// We do not need documentation thanks to noweb
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false
