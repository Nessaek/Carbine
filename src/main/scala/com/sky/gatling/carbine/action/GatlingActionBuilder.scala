package com.sky.gatling.carbine.action

import io.gatling.commons.stats.Status
import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.session.Expression
import io.gatling.core.stats.StatsEngine
import io.gatling.core.structure.ScenarioContext


case class GatlingActionBuilder[A,B](requestName: Expression[String], functionUnderTest: A => B, check: (B,B) => Status) extends ActionBuilder {
   override def build(ctx: ScenarioContext, next: Action): Action = {
    val statsEngine: StatsEngine = ctx.coreComponents.statsEngine
    GatlingAction(requestName, functionUnderTest, statsEngine, next, check)
  }
}


