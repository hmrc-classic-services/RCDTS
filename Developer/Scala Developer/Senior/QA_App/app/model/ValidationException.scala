package model

case class ValidationException(val errors : Seq[String]) extends Exception{

}
