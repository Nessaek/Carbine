name := "carbine"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= {
  val gatlingVersion = "2.3.1"

  Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion,
    "io.gatling" % "gatling-test-framework" % gatlingVersion
  )

}