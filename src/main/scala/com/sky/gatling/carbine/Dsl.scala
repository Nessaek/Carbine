package com.sky.gatling.carbine

import com.sky.gatling.carbine.builder.ActionBuilder
import com.sky.gatling.carbine.check.CheckSupport
import com.sky.gatling.carbine.protocol.ProtocolBuilder
import io.gatling.core.session.Expression

trait Dsl[K, V] extends CheckSupport {

  val cassandra: ProtocolBuilder.type = ProtocolBuilder

  def cassandra(requestName: Expression[String]): ActionBuilder[K, V] =
    ActionBuilder(requestName)
}
