package controllers

import javax.inject._

import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc._

@Singleton
class ErrorController @Inject()(cc: ControllerComponents)(implicit text: MessagesApi) extends AbstractController(cc) with I18nSupport {

  def general() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.error())
  }

  def validationException() =  Action { implicit request: Request[AnyContent] =>
    Ok(views.html.error())
  }

}
