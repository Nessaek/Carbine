package com.sky.gatling.carbine.action

package com.sky.cel.mapper.perf.gatling.action

import io.gatling.commons.stats.{KO, OK, Status}
import io.gatling.commons.util.ClockSingleton.nowMillis
import io.gatling.core.action.Action
import io.gatling.core.session.{Expression, Session}
import io.gatling.core.stats.StatsEngine

case class Action(requestName: Expression[String],
                               repository: String,
                               statsEngine: StatsEngine,
                               nextAction: Action) extends ActionLogging {

  override def next: Action = nextAction

  override def name: String = "FindAction"

  override def execute(session: Session): Unit = {
    val key: Option[String] = session.attributes.get("classifKey").asInstanceOf[Option[String]]
    val start = nowMillis
    val result: Status = key.flatMap(string => repository.findByClassifKey(string).map(_ => OK)).getOrElse(KO)
    log(start, nowMillis, requestName, result, session, statsEngine)
    nextAction ! session
  }
}

