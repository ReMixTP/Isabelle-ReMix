package isabelle_remix.controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._


/**
  * Provide access to language information in ReMix,
  * including which languages are supported, and some information about them
  */
class IsabelleController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc)
{

  /**
    * Return a list of languages that ReMix currently supports through its plugins
    */

  def about() = Action { implicit request: Request[AnyContent] =>
    Ok(JsArray(Array(Json.obj(
      "plugin" -> "com.isabelle",
      "name" -> "Isabelle",
      "description" -> "The Isabelle Theorem Prover is a generic higher-order theorem prover",
      "website" -> "http://isabelle.in.tum.de/",
      "version" -> "0.1.0",
      "icon" -> "None",
      "base" -> "http://aarons-macbook:5001",
      "provides" -> Json.obj(
        "language" -> "/api/v0.1.0/languages"
      )
    ))))
  }
}
