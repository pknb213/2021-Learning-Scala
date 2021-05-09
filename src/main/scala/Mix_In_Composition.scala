object Mix_In_Composition extends App {
  // 단일 상속만 지원하는 여러 언어와 다르게 더욱 일반화된 시각에서 클래스를 재사용한다.
  // 새로운 클래스를 정의할 때 클래스의 새로운 멤버 정의를 재사용할 수 있다. 이를 믹스인 클래스 컴포지션이라 한다.
  // 다음은 이터레이터를 추상화한 예제이다
  abstract class AbsIterator {
    type T
    def hashNext: Boolean
    def next(): T
  }
  // 이터레이터가 반환하는 모든 항목에 주어진 함수를 적용해주는 foreach 메소드로
  // AbsIterator를 확장한 믹스인 클래스를 보면, 믹스인으로 사용할 수 있는 클래스를 정의하기 위해선 trait 키워드를 사용한다.
  trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit): Unit = {
      while (hashNext) f(next())
    }
  }
  // 다음은 주어진 문자열의 캐릭터를 반환해주는 콘크리트 이터레이터 클래스이다.
  class StringIterator(s: String) extends AbsIterator{
    type T = Char
    private var i = 0
    def hashNext = i < s.length()
    def next() = {
      val ch= s charAt i;
      i += 1;
      ch
    }
  }
  val str = new StringIterator("Python")
  while (str.hashNext) println(str.next())
  println("--------")
  // StringIterator 와 RichIterator 를 하나의 클래스로 합치고 싶을 때,
  // 두 클래스 모두 코드가 포함된 멤버 구현을 갖고 있기 때문에 단일 상속과 인터페이스만으로는 불가능하다.
  // 이런 상황에서 스칼라는 믹스인 클래스 컴포지션으로 해결할 수 있다.
  // 주어진 문자열에 포함된 모든 캐릭터를 한 줄로 출력해주는 다음의 테스트 프로그램과 같이 통합할 수 있다.
  class Iter extends StringIterator("Scala") with RichIterator
  val iter = new Iter
  iter foreach println
}
