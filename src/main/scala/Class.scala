object Class extends App {
  // Class : 멤버라고 통칭하는 메서드, 값, 변수, 타입, 객체, 트레이트, 클래스를 포함할 수 있습니다.
  class Point(var x: Int, var y: Int) {
    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }
    override def toString: String =
      s"($x, $y)"
  }

  println({
    val point = new Point(2, 3)
    point
  })
  // Constructors (생성자) :  다른 언어와 달리 클래스 서명부 (signature)에 있습니다.
  class Point2(var x: Int = 0, var y: Int = 0)
  val origin = new Point2
  val point1 = new Point2(1) // 기본적으로 왼쪽 파라미터부터 전달된다. y 파라미터에 전달하고자 한다면 y=2 형태를 사용한다.
  println(point1.x)

  // Private Members & Getter/Setter Syntax
  // 기본 생성자에서 val, var 으로 지정된 매개변수는 public 입니다.
  // val, var 으로 지정하지 않은 매개변수는 private 값으로 클래스 내에서만 참조합니다.
  class Point3 {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    // Value _x, _y 에 접근하기 위한 메서드
    def x = _x
    def y = _y

    // Value _x, _y 값을 검증하고 설정하기 위한 메서드
    // setter 메서드를 위한 특별한 문법에 주목해야합니다.
    // getter 메서드 식별자에 '_=' 를 붙이고 매개변수가 뒤따르는 형식입니다.
    def x_= (newValue: Int): Unit = {
      if (newValue < bound) printSuccess(f = 'x', nv = newValue) else printWarning
    }
    def y_= (newValue : Int): Unit = {
      if (newValue < bound) printSuccess(f = 'y', nv = newValue) else printWarning
    }
    private def printSuccess(f: Int, nv: Int) = {
      if (f == 'x') _x = nv
      else _y = nv
      println("Success: " + _x + " " + _y)
    }
    private def printWarning = println("Warning: Out of bounds")
  }
  val point3 = new Point3
  point3.x = 99
  point3.y = 101 // Warning: Out of bounds
}
