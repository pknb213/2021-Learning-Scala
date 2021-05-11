object Higher_Order_Functions extends App {
  // Higer-order-function : 다른 함수를 파라미터로 받거나 결과 값이 함수인 것을 의미한다.
  def apply(f: Int => String, v: Int) = f(v)

  class Decorator(left: String, right: String) {
    def layout[A](x: A) = left + x.toString() + right
  }
  println({
    val decorator = new Decorator("ㄴ[", "]ㄱ")
    apply(decorator.layout, 7)
  })
  """
    | 메소드 decorator.layout은 메소드 apply에서 요구하는 바와 같이 타입 Int => String의 값으로 자동 강제된다.
    | 메소드 decorator.layout이 다형성 메소드(즉, 자신의 서명 타입 중 일부를 추상화)이고 스칼라 컴파일러는
    |  가장 적합한 메소드 타입을 인스턴스화 해야만 한다는 점을 명심해야한다.
    |""".stripMargin

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }
  // 리턴 값이 함수인 고차 함수 예제
  val domainName = "www.example.com"
  def getURL = urlBuilder(ssl=true, domainName)
  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query)
  println({
    url
  })
}
