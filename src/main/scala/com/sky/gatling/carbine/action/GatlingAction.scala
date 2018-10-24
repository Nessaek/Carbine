package com.sky.gatling.carbine.action

import io.gatling.commons.stats.Status
import io.gatling.commons.util.ClockSingleton.nowMillis
import io.gatling.core.action.Action
import io.gatling.core.session.{Expression, Session}
import io.gatling.core.stats.StatsEngine

case class GatlingAction[A,B](requestName: Expression[String],
                              f: A => B,
                         statsEngine: StatsEngine,
                         nextAction: Action,
                              check: (B,B) => Status) extends ActionLogging {

  override def next: Action = nextAction

  override def name: String = "Action"

  override def execute(session: Session): Unit = {
    val a: Option[A] = session.attributes.get("nessa").asInstanceOf[Option[A]]
    val start = nowMillis
    val b: B = f(a.get)
    val result: Status = check(b)
    log(start, nowMillis, requestName, result, session, statsEngine)
    nextAction ! session
  }
}

