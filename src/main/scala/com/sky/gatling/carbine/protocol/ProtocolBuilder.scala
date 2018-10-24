package com.sky.gatling.carbine.protocol

case class ProtocolBuilder[A,B](functionUnderTest: A => B) {
  def build = GatlingProtocol(functionUnderTest)
}
