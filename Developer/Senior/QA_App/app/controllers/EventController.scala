package controllers

import javax.inject._

import model.ValidationException
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc._
import utils.DateUtil

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class EventController @Inject()(cc: ControllerComponents)(val text : MessagesApi) extends AbstractController(cc) with I18nSupport {

  def addEvent() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.addEvent())
  }

  def deleteEvent() = Action { implicit request: Request[AnyContent] =>
      Ok(views.html.deleteEvent())
  }
  def postDeleteEvent() = Action { implicit request =>
    val id =  request.body.asFormUrlEncoded.get.get("eventId").head(0).toLong
    if (EventOrganiser.deleteEvent(id)) {
      Redirect(routes.HomeController.index(Some("Delete request complete")))
    } else {
      Ok(views.html.deleteEvent("Event ID not recognised"))
    }
  }


  def postAddEvent(eventName : String, eventDate: String, eventType : String, eventDesc : String) = Action { implicit request: Request[AnyContent] =>
    try {
      EventOrganiser.addEvent(eventName, eventDesc, eventType, DateUtil.parse(eventDate))
      Redirect(routes.HomeController.index(Some("Event Successfully Added")))
    } catch {
      case ex : ValidationException => Redirect(routes.ErrorController.validationException(Some(ex)))
      case ex : Throwable => Redirect(routes.ErrorController.general())
    }
  }
}
