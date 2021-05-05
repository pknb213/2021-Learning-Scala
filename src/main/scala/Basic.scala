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
  // Unit타입의 싱글톤 값이 쓰인다는 차이가 있다.
  class Greeter(prefix: String, suffix: String){
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }
  println({
    val greeter = new Greeter("My name is ", "!!!")
    greeter.greet("Scala")
    greeter
  })

}
