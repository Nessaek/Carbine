package com.sky.gatling.carbine.action

import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.session.Expression
import io.gatling.core.stats.StatsEngine
import io.gatling.core.structure.ScenarioContext

case class ActionBuilder[K, V](requestName: Expression[String], repository: PersistenceService[K, V]) {
  override def build(ctx: ScenarioContext, next: Action): Action = {
    val statsEngine: StatsEngine = ctx.coreComponents.statsEngine
    GatlingAction(requestName, repository, statsEngine, next)
  }
}


