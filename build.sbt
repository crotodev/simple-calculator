val catsVersion = "2.9.0"
val spireVersion = "0.17.0"

lazy val root = (project in file("."))
  .settings(
    name := "simple-calculator",
    organization := "com.github.crotodev",
    scalaVersion := "2.13.12",
    maxErrors := 3,
    startYear := Some(2023),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "spire" % spireVersion,
      "ch.qos.logback" % "logback-classic" % "1.4.7",
      "org.scalatest" %% "scalatest" % "3.2.15" % Test
    ),
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint:_,-missing-interpolator",
      "-Yno-adapted-args",
      "-Ywarn-unused-import",
      "-Xfuture"
    ),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value(x)
    },
    semanticdbEnabled := true,
    sbtPlugin := true
  )
