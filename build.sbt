name := "finagle-kafka"

description := "An Apache Kafka client in Netty and Finagle."

organization := "com.github.okapies"

organizationHomepage := Some(url("https://github.com/okapies"))

version := "0.2.3-SNAPSHOT"

scalaVersion := "2.12.7"

libraryDependencies ++= List(
  "com.twitter" %% "finagle-core" % "6.43.0",
  "org.apache.kafka" %% "kafka" % "0.10.1.1"
    exclude("com.101tec", "zkclient")
    exclude("com.yammer.metrics", "metrics-core")
    exclude("net.sf.jopt-simple", "jopt-simple")
    exclude("org.apache.zookeeper", "zookeeper")
    exclude("org.xerial.snappy", "snappy-java"),
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  // dependencies for kafka-test
  "junit" % "junit" % "4.11" % "test",
  "org.apache.curator" % "curator-test" % "2.11.0" % "test",
  "com.101tec" % "zkclient" % "0.8" % "test",
  "com.yammer.metrics" % "metrics-core" % "2.2.0" % "test",
  "org.apache.kafka" %% "kafka" % "0.10.1.1" % "test" classifier "test"
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/okapies/finagle-kafka</url>
    <licenses>
      <license>
        <name>The MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:okapies/finagle-kafka.git</url>
      <connection>scm:git:git@github.com:okapies/finagle-kafka.git</connection>
    </scm>
    <developers>
      <developer>
        <id>okapies</id>
        <name>Yuta Okamoto</name>
        <url>https://github.com/okapies</url>
      </developer>
    </developers>)
