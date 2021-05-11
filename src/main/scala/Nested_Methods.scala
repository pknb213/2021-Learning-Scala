object Nested_Methods extends App {
  // Nested-methods : 메소드 안에 메소드를 구현할 수 있다.
  def filter(xs: List[Int], threshold: Int) = {
    def process(ys: List[Int]): List[Int] = {
      println("processing : " + ys)
      if (ys.isEmpty) ys
      else if (ys.head < threshold) ys.head :: process(ys.tail)
      else process(ys.tail)
    }
    process(xs)
    }
    println(filter(List(1,9,2,8,3,7,4), 5))

  // 좀 더 간단한 예제인 팩토리알이다.
  def factorial (x: Int): Int = {
    def fact (x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact (x-1, x * accumulator)
    }
    fact(x, 1)
  }
  println("Factorial of 4: " + factorial(4))
}
