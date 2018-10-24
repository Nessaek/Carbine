package com.sky.gatling.carbine.protocol

import io.gatling.core.protocol.ProtocolComponents
import io.gatling.core.session.Session

case class Components[A,B](protocol: GatlingProtocol[A,B])
  extends ProtocolComponents {

  override def onStart: Option[Session => Session] = None

  override def onExit: Option[Session => Unit] = None
}
