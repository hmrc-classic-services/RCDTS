class BlogSpec extends FlatSpec with ShouldMatchers with HtmlUnit {

  /**
    * Those unfamiliar with Scala and its use of selenium might find this resource useful:
    * [[http://www.scalatest.org/user_guide/using_selenium]]
    */

  val host = "http://localhost:8090/"

  "The home page" should "have the correct title" in {
    go to (host + "index.html")
    pageTitle should be ("Welcome To Play")
  }

  "The home page" should hvae a "field" in {
    go to host
    click on "q" //defaults to ID
    click on id("q")
    click on name("q")
    click on linkText("click me")
    textField("q").value = "cheese"
    submit
    eventually {
      title should be ("cheese!")
      textField("q").value should be ("cheese")
    }
  }
}