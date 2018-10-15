package com.sky.gatling.carbine.action

import io.gatling.commons.stats.Status
import io.gatling.core.action.ChainableAction
import io.gatling.core.session.{Expression, Session}
import io.gatling.core.stats.StatsEngine
import io.gatling.core.stats.message.ResponseTimings

trait ActionLogging extends ChainableAction {

  def log(start: Long, end: Long, requestName: Expression[String], status: Status, session: Session, statsEngine: StatsEngine): Unit = {
    val timing = ResponseTimings(start, end)
    requestName.apply(session).foreach { resolvedRequestName =>
      statsEngine
        .logResponse(session, resolvedRequestName, timing, status, None, None)
    }
  }
}
