package com.sky.gatling.carbine.cassandra.connector

import com.datastax.driver.core.{HostDistance, PoolingOptions}
import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint}
import com.typesafe.config.ConfigFactory

object PhantomConnector {

  def config = ConfigFactory.load()

  val keyspace: String = config.getString("cassandra.keyspace")

  val username: String = config.getString("cassandra.username")
  val password: String = config.getString("cassandra.password")

  val port: Int = config.getInt("cassandra.port")

  private val pooling: PoolingOptions = new PoolingOptions()
    .setCoreConnectionsPerHost(HostDistance.LOCAL, 4)
    .setMaxConnectionsPerHost(HostDistance.LOCAL, 10)
    .setMaxRequestsPerConnection(HostDistance.LOCAL, 32768)

  lazy val connector: CassandraConnection = ContactPoint(port)
    .noHeartbeat()
    .withClusterBuilder(_.withoutJMXReporting()
      .withoutMetrics()
      .withPoolingOptions(pooling)
      .withCredentials(username, password))
    .keySpace(keyspace)

}
