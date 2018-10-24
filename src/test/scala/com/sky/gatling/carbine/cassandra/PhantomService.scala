package com.sky.gatling.carbine.cassandra

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import com.sky.gatling.carbine.model.Classification
import com.sky.gatling.carbine.cassandra.model.ClassificationModel

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class PhantomService(override val connector: CassandraConnection) extends Database[PhantomService](connector) with PersistenceService[String, Classification]{

  object ClassificationModel extends ClassificationModel with connector.Connector

  def save(classification: Classification): Option[Classification] = {
   val queryFuture: Future[ResultSet] = ClassificationModel.store(classification).future()
    Await.result(queryFuture, 2.seconds)
    Some(classification)
  }

  def findByClassifKey(classifKey: String): Option[Classification] = {
    Await.result(ClassificationModel.findByClassifKey(classifKey), 2.seconds)
  }

}
