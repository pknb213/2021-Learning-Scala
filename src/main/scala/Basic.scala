object Basic extends App {
  // Block : 블럭 안에 있는 표현식의 결과는 블록 전체의 결과이다
  println({
    val x = 1 + 1
    x + 2
  })
  // Function : 인자를 갖을 수 있는 표현식 (함수)
  println({
    val f = (x: Int) => x + 1
  f(5)
  })
  // Method : 메소드는 함수와 비슷하게 보이고 동작하는거 같지만
  // def를 사용해 정의하고 이름, 매개변수, 반환 타입 그리고 본문을 작성한다
  println({
    def add_and_multiple(x: Int, y: Int)(m: Double): Double = (x+y) * m
    add_and_multiple(2, 4)(1.5)
  })
  // 매개변수를 갖지 않는 메소드는 다음 형태이다.
  println({
    def name: String = System.getProperty("user.name")
    "Hello, " + name + "!!!!"
  })
  // Class : 이름과 생성자 매개변수를 정의한다.
  // greet 메소드 반환 타입은 Unit으로 void와 유사하다. 실제로 ()로 쓰여진
  // Unit 타입의 싱글톤 값이 쓰인다는 차이가 있다.
  println({
    class Greeter(prefix: String, suffix: String){
      def greet(name: String): Unit =
        println(prefix + name + suffix)
    }
    val greeter = new Greeter("My name is ", "!!!")
    greeter.greet("Scala")
    greeter
  })
  // Case Class : 스칼라만의 특별한 타입의 클래스이며
  // 케이스 클래스는 변하지 않으며 값으로 비교한다.
  println({
    case class Point(x: Int, y: Int)
    val point = Point(1, 2)
    val point2 = Point(1, 2)
    val point3 = Point(3, 6)
    if (point == point2){ println(point + " and "  + point2 + " are same.") }
    else { println(point + " and "  + point2 + " are different.")}
    if (point == point3){ point + " and "  + point3 + " are same." }
    else { point + " and "  + point3 + " are different." }
  })
  // Object : 자가 정의에 대한 단일 인스턴스이다. 싱글톤이라 생각하면 된다.
  // 객체 이름을 참조하여 접근할 수 있다.
  println({
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 10
        counter
      }
    }
    val newId: Int = IdFactory.create()
    println(newId)
    val newId2 = IdFactory.create()
    newId2
  })
  // Trait : 특정 필드와 메소드를 가진 타입이고 다른 트레이트와 결합할 수 있다.
  println({
    trait Greeter {
      def greet(name: String): Unit = println("Hi, " + name + ".")
    }
    // extends 키워드로 상속하고 override 키워드로 오버라이드한다.
    class DefaultGreeter extends Greeter
    class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
      override def greet(name: String): Unit = {
        println(prefix + name + postfix)
      }
    }
    val greeter = new DefaultGreeter()
    greeter.greet("Scala Developer")
    val customGreeter = new CustomizableGreeter("Junior, ", "!!!")
    customGreeter.greet("Developer")
    greeter
  })
  // Main Method : 프로그램의 진입 지점이다. JVM 에서 필요하며 문자열 배열 하나를 인자로 가진다.
  // 이 프로젝트에서는 extends App 으로 진입 지점을 설정해서 동작하지 않는다.
  object Main {
    def main(args: Array[String]): Unit = println("Hi Scala World~")
  }
}
