object Tuple extends App {
  // Tuple : 정해진 요소(element)를 가지는 값으로 각 요소는 고유한 타입을 가진다.
  // 튜플은 불변적이다.
  // 아래 변수의 추론된 타입은 Tuple[String, Int]의 약칭인 (String, Int)이다.
  val ingredient = ("Sugar", 25)
  // 엘리먼트 접근하기
  println(ingredient._1, ingredient._2)
  // 튜플 패턴 매칭
  val (name, quantity) = ingredient // 여기서 name, quantity 의 추론된 타입은 String, Int이다.
  println(name, quantity)
  // 튜플 패턴 매칭 2
  val planets = List(
    ("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3)
  )
  planets.foreach{
    case ("Earth", distance) =>
      println(s"Our planet is $distance million kilometers from the sun\n")
    case _ =>
  }
  for ((a, b) <- planets) { // for comprehension
    println(a + b)
  }
  // 튜플과 케이스 클래스
  // 때때로 둘 중 어느것을 사용해야할지 힘들 수 있다. 케이스 클래스는 이름 있는 요소를 갖는다.
  // 요소의 이름들은 코드에서 가독성을 높일 수 있다.
  // case class Planet(name: String, distance: Double)로 정의하는게 나을 수 있다.
}
