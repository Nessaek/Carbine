package com.sky.gatling.carbine.protocol

case class ProtocolBuilder[A](persistenceService: A) {
  def build = Protocol(persistenceService)
}
