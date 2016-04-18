package org.cinqcloches.jws

import java.security.Provider
import java.security.Security

import javax.crypto._
import javax.crypto.spec._
import java.io._
import java.security._
import java.security.spec._

import com.nimbusds.jose._
import com.nimbusds.jose.crypto._
import java.util.Base64
import javax.xml.bind.DatatypeConverter

import com.nimbusds.jose.crypto.bc.BouncyCastleProviderSingleton

// Private: openssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt
// Public: openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der

class PS256Signer(fileName:String) {

  // Loading the private key
  val f = new File(fileName)
  val fis = new FileInputStream(f)
  val dis = new DataInputStream(fis)
  val keyBytes = Array.ofDim[Byte](f.length().toInt)
  dis.readFully(keyBytes)
  dis.close()

  // Getting the algo
  val bc = BouncyCastleProviderSingleton.getInstance()
  Security.addProvider(bc)
  val spec = new PKCS8EncodedKeySpec(keyBytes)
  val kf = KeyFactory.getInstance("RSA")
  val pk = kf.generatePrivate(spec)
  val signer = new RSASSASigner(pk)

  // Signature
  def sign(payload: String):String = {
    val jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.PS256), new Payload(payload))
    jwsObject.sign(signer)
    jwsObject.serialize()
  }
}
