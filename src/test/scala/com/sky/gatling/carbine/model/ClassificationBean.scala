package com.sky.gatling.carbine.model

import java.util

import com.datastax.driver.mapping.annotations.{PartitionKey, Table}

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Table(keyspace = "smartlist", name = "classification")
case class ClassificationBean(
                               @(PartitionKey@field)
                               @BeanProperty
                               var classifKey: String,

                               @BeanProperty
                               var categoryType: Int,

                               @BeanProperty
                               var parentalRating: Int,

                               @BeanProperty
                               var hideIfEmpty: Boolean,

                               @BeanProperty
                               var usage: Int,

                               @BeanProperty
                               var filter: String,

                               @BeanProperty
                               var fieldTrial: Int,

                               @BeanProperty
                               var description: String,

                               @BeanProperty
                               var name: String,

                               @BeanProperty
                               var shortName: String,

                               @BeanProperty
                               var softKey: String,

                               @BeanProperty
                               var resourcePackage: String,

                               @BeanProperty
                               var renderHint: String,

                               @BeanProperty
                               var darwinHint: String,

                               @BeanProperty
                               var uuid: String,

                               @BeanProperty
                               var classifId: Long,

                               @BeanProperty
                               var classifications: util.List[String] = new util.ArrayList[String](),

                               @BeanProperty
                               var parent: String = "",

                               @BeanProperty
                               var ordered: String = ""
                             ) {
  def this() {
    this("", 0, 0, false, 0, "", 0, "", "", "", "", "", "", "", "", 0L)

  }
}
