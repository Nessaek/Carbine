package com.sky.gatling.carbine.protocol

import io.gatling.core.protocol.Protocol

class GatlingProtocol[A,B](functionUnderTest: A => B) extends Protocol {

}

object GatlingProtocol {
  def apply[A,B](functionUnderTest: A => B) =
    new GatlingProtocol(functionUnderTest)
}
