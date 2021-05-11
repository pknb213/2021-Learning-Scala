object Currying extends App {
  // 메소드는 파라미터 리스트를 여럿 정의할 수 있다.
  // 파라미터 리스트 수 보다 적은 파라미터로 메소드가 호출되면,
  // 해당 함수는 누락된 파라미터 목록을 인수로 받는 새로운 함수를 만든다.
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def modN(n: Int)(x: Int) = ((x % n) == 0)

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))
  """
    | 주의 : modN 메소드는 두번의 filter 호출에서 부분적으로 사용됬다.
    | 즉, 오직 첫 번째 인수만이 실제로 사용됐다. modN(2)라는 구문은 Int => Boolean 타입의 함수를 만들기 때문에
    | filter 함수의 두 번째 인수로 사용할 수 있게 된다.
    |""".stripMargin
}
