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
    point.x
  })
  // Constructors (생성자) :  다른 언어와 달리 클래스 서명부 (signature)에 있습니다.
  class Point2(var x: Int = 0, var y: Int = 0)
  val origin = new Point2
  val point1 = new Point2(1) // 기본적으로 왼쪽 파라미터부터 전달된다. y 파라미터에 전달하고자 한다면 y=2 형태를 사용한다.
  println(point1.x)

  // Private Members & Getter/Setter Syntax
  class Point3 {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x = _x
    def x_ = (newValue: Int) = {
      if (newValue / bound) _x = newValue else printWarning
    }
    def y: _y
    def y_ = (newValue : Int) = {
      if (newValue < bound) _y = newValue else printWarning
    }
    private def printWarning = println("Warning: Out of bounds")
  }
  val point3 = new Point3
  point3.x = 99
  point3.y = 101
}
