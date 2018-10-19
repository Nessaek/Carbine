package com.sky.gatling.carbine.protocol

import io.gatling.core.protocol.Protocol

class Protocol[K, V](val persistenceService: PersistenceService[K, V])
  extends Protocol {}

object Protocol {
  def apply[K, V](persistenceService: PersistenceService[K, V]): CassandraProtocol[K, V] =
    new CassandraProtocol(persistenceService)
}
