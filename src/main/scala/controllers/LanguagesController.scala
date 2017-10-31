package isabelle_remix.controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._


/**
  * Provide access to language information in ReMix,
  * including which languages are supported, and some information about them
  */
class LanguagesController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc)
{

  /**
    * Return a list of languages that ReMix currently supports through its plugins
    */
  def list() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.obj(
      "languages" -> Set("lang.isabelle")
    ))
  }

  def about(language: String) = Action { implicit request: Request[AnyContent] =>
    Ok(Json.obj(
      "language" -> "lang.isabelle",
      "name" -> "Isabelle Sentential Language",
      "description" -> "The syntax of Isabelle"
    ))
  }

  def verify(language: String) = Action { implicit request: Request[AnyContent] =>
    BadRequest(Json.obj(
      "result" -> "failure",
      "reason" -> "Not implemented yet."
    ))
  }
}
