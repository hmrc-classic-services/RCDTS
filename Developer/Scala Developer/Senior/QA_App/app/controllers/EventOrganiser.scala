package controllers

import scala.collection.mutable.{ArrayBuffer, HashMap}
import java.util.UUID
import java.time.LocalDateTime

import model.{Event, ValidationException}
import play.api.data.validation.ValidationError

import scala.collection.mutable

object EventOrganiser {
  val events : HashMap[Long, Event] = HashMap()

//TODO cache all events in session memory?
  def nextId : Long = {
    var random = UUID.randomUUID().getMostSignificantBits()
    while(events.keySet.contains(random) || random < 0 ) {
      random = UUID.randomUUID().getMostSignificantBits()
    }
    random
  }

  def addEvent(eventName : String, description : String, eventType : String, dateTime : LocalDateTime) = {
      validate(eventName, description, eventType, dateTime)
      val id = nextId
      events.put(id, new Event(id, eventName, description, eventType, dateTime))
  }

  def deleteEvent(eventId : Long): Boolean = {
    if(events.contains(eventId)) {
      events.remove(eventId)
      true
    } else {
      false
    }
  }
  def getEvents() = {  events  }

  def clear() = { events.clear() }

  def validate(name: String, description: String, eventType: String, dateTime: LocalDateTime): Unit = {
    var errors = new StringBuilder
    if(dateTime.isBefore(LocalDateTime.now())) {
      errors.append("Event date must be in the future")
    }
    if(!List("SOCIAL","CHARITY","PRIVATE").contains(eventType.toUpperCase)){
      errors.append("Event type does not match: 'SOCIAL' 'CHAIRTY' 'PRIVATE'")
    }
    if(description.length > 30){
      errors.append("Event description cannot be longer than 30 characters")
    }
    if(errors.size != 0) {
      throw new ValidationException(errors.mkString(System.lineSeparator()))
    }
  }
}