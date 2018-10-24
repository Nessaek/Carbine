package com.sky.gatling.carbine.cassandra.model

import com.outworkers.phantom.Table
import com.outworkers.phantom.dsl._
import com.sky.gatling.carbine.model.Classification

import scala.concurrent.Future


trait ClassificationModel extends Table[ClassificationModel,Classification] {
  override def tableName: String = "classification"

  object classifKey extends StringColumn with PartitionKey

  object categoryType extends IntColumn

  object parentalRating extends IntColumn

  object hideIfEmpty extends BooleanColumn

  object usage extends IntColumn

  object filter extends StringColumn

  object fieldTrial extends IntColumn

  object description extends StringColumn

  object name extends StringColumn

  object shortName extends StringColumn

  object softKey extends StringColumn

  object resourcePackage extends StringColumn

  object renderHint extends StringColumn

  object darwinHint extends StringColumn

  object uuid extends StringColumn

  object classifId extends LongColumn

  object classifications extends ListColumn[String]

  object parent extends StringColumn

  object ordered extends StringColumn

   def findByClassifKey(classifKey: String): Future[Option[Classification]] = {
    select.where(_.classifKey eqs classifKey)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .one()
  }

}
