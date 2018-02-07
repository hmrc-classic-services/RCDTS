package model

case class ValidationException(val errors : String) extends Exception{

}
