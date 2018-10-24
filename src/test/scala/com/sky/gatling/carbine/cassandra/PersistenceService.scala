package com.sky.gatling.carbine.cassandra

trait PersistenceService[K, V] {

  def save(v: V): Option[V]

  def findByClassifKey(key: K): Option[V]

}