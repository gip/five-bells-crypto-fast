
name := "test"

version := "1.0"

scalaVersion := "2.11.8"
resolvers +=  "Sonatype OSS Snapshots" at "http://mvnrepository.com/artifact"
resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
resolvers += "central" at "http://repo1.maven.org/maven2/"
resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "com.nimbusds"         % "nimbus-jose-jwt" % "4.16.1",
    "org.bouncycastle"     % "bcprov-jdk15on"  % "1.54",
    "io.spray"            %%  "spray-can"      % sprayV,
    "io.spray"            %%  "spray-routing"  % sprayV,
    "io.spray"            %%  "spray-json"     % "1.3.1",
    "io.spray"            %%  "spray-testkit"  % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"     % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"   % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"    % "2.3.11" % "test"
  )
}

