package org.cinqcloches.server

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json._

import org.cinqcloches.jws._

class SignatureService(fileName:String) extends Actor with HttpService {
  def actorRefFactory = context
  def receive = runRoute(signRoute)
  val signer = new PS256Signer(fileName)
  val signRoute = 
    path("crypto" / "ps256" / "sign") {
      put {
        entity(as[String]) { body =>
          println(body)
          complete(signer.sign(body))
        }
      }
    }
}
