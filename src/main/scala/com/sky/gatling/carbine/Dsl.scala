package com.sky.gatling.carbine

import com.sky.gatling.carbine.action.GatlingActionBuilder
import com.sky.gatling.carbine.check.CheckSupport
import com.sky.gatling.carbine.protocol.ProtocolBuilder
import io.gatling.core.Predef.Status
import io.gatling.core.session.Expression

trait Dsl[K, V] extends CheckSupport {

  val dsl: ProtocolBuilder.type = ProtocolBuilder

  def dsl[A,B](requestName: Expression[String], functionUnderTest: A => B, checkResult:(B,B) => Status): GatlingActionBuilder[A, B] = GatlingActionBuilder(requestName, functionUnderTest, checkResult)


}
