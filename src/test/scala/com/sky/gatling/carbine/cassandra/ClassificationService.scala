package com.sky.gatling.carbine.cassandra

import java.util.UUID

import com.sky.gatling.carbine.model.{Classification, ClassificationBean}

import scala.collection.immutable.Queue
import scala.util.Random

object ClassificationService {

  private val keyLength: Int = 5

  var ids: Queue[String] = Queue[String]()

  def getId: Option[String] = {
    val tuple: Option[(String, Queue[String])] = ids.dequeueOption
    ids = tuple.fold(ids)(_._2)
    tuple.map(_._1)
  }

  def generateClassificationBean(): ClassificationBean = {
    ClassificationBean(
      classifKey = generateStringAndQueue(),
      categoryType = generateRandomIntUpto(),
      parentalRating = generateRandomIntUpto(),
      hideIfEmpty = false,
      usage = generateRandomIntUpto(),
      filter = "",
      fieldTrial = generateRandomIntUpto(),
      description = generateRandomStringWithLength(40),
      name = generateRandomStringWithLength(15),
      shortName = generateRandomStringWithLength(10),
      softKey = generateRandomStringWithLength(),
      resourcePackage = "",
      renderHint = "",
      darwinHint = "",
      uuid = UUID.randomUUID().toString,
      classifId = generateRandomIntUpto(10000)
    )
  }

  def generateClassification(): Classification = {
    Classification(
      classifKey = generateStringAndQueue(),
      categoryType = generateRandomIntUpto(),
      parentalRating = generateRandomIntUpto(),
      hideIfEmpty = false,
      usage = generateRandomIntUpto(),
      filter = "",
      fieldTrial = generateRandomIntUpto(),
      description = generateRandomStringWithLength(40),
      name = generateRandomStringWithLength(15),
      shortName = generateRandomStringWithLength(10),
      softKey = generateRandomStringWithLength(),
      resourcePackage = "",
      renderHint = "",
      darwinHint = "",
      uuid = UUID.randomUUID().toString,
      classifId = generateRandomIntUpto(10000)
    )
  }

  private def generateStringAndQueue(): String = {
    val str = generateRandomStringWithLength(keyLength)
    ids = ids.enqueue(str)
    str
  }

  private def generateRandomStringWithLength(length: Int = 20): String =
    Random.alphanumeric.take(length).mkString

  private def generateRandomIntUpto(max: Int = 10): Int =
    Random.nextInt(max)

}
