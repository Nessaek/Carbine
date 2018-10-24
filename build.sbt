name := "carbine"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= {
  val gatlingVersion = "2.3.1"
  val circeVersion = "0.9.3"
  val hazelcastVersion = "3.10.5"
  val quillVersion = "2.5.4"
  val phantomVersion = "2.24.10"
  val scalaTestVersion = "3.0.5"
  val scalaCheckVersion = "1.14.0"
  val datastaxVersion = "3.6.0"

  Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion,
    "io.gatling" % "gatling-test-framework" % gatlingVersion,
    "com.hazelcast" % "hazelcast" % hazelcastVersion,
    "com.datastax.cassandra" % "cassandra-driver-core" % datastaxVersion,
    "com.datastax.cassandra" % "cassandra-driver-mapping" % datastaxVersion,
    "io.getquill" %% "quill"  % quillVersion,
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "com.outworkers"  %% "phantom-dsl" % phantomVersion,
    "com.outworkers" %% "phantom-streams" % phantomVersion,
    "org.scalactic" %% "scalactic" % scalaTestVersion % "test",
    "org.scalatest" %% "scalatest" % scalaTestVersion,
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test"
  )

}