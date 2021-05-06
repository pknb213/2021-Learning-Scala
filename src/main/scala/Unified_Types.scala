object Unified_Types extends App {
  /*
  스칼라 타입 계층 구조
  Any 는 모든 타입들의 슈퍼타입이며 Top 타입이라고도 합니다.
  Any 에는 equals, hashCode, toString 같은 특정 범용 메서드가 정의되어 있고 직접적으로
  AnyVal, AnyRef 라는 두개의 서브클래스를 갖습니다.

  AnyVal 클래스는 값(Value) 타입을 대표합니다. Double, Float, Long, Int, Short, Byte, Char, Unit, Boolean
  미리 정의된 아홉 개의 값 타입이 있으며, 이 타입들은 Null 값을 가질 수 없습니다.
  Unit 은 의미 없는 정보를 갖는 값 타입입니다. () 와 같이 문자 그대로 선언할 수 있는 Unit 의 인스턴스는 오직 하나만 있습니다.
  모든 함수는 무언가를 반환해야하기 때문에 Unit 은 유용한 반환 타입입니다.

  AnyRef 클래스는 참조(Reference) 타입을 대표합니다. 값 타입이 아닌 모든 타입은 참조 타입으로 정의됩니다.
  스칼라에서 사용자 정의 타입은 모두 AnyRef 서브 타입입니다. 스칼라가 자바 환경에서 사용되면 java.lang.Object에 해당합니다.
  */
  // 아래 예제는 문자열 값, 정수 값, 문자 값, Boolean 값과 함수 역시 모두 객체로 취급됨을 보여줍니다.
  println({
    val list: List[Any] = List(
      "a string",
      732,
      'X',
      true,
      () => "anonymous function"
    )
    list.foreach(e => println(e))
    list
  })
  // Type Casting : Value 타입은 다음과 같이 Casting 할 수 있습니다.
  // Byte -> Short -> Int -> Long -> Float -> Double,   Char -> Int
  println({
    val x: Long = 987654321
    val y: Float = x // 9.8765434E8 (이 경우 일부 자리수가 소실되었음을 주의)
    val face: Char = '☺'
    val number: Int = face // 9786
    println(x, y, face, number)
    // val z: Long = y 적합하지 않음(캐스팅 불가) Type Mismatch 빌드 에러 발생

    /*
    Nothing, Null : Nothing 은 모든 타입의 서브 타입이며, Bottom 타입이라고도 합니다.
    Nothing 은 값이 없음ㅇ르 의미하는 타입입니다. 일반적으로 예외 발생, 프로그램 종료 또는 무한 루프와 같은
    비종료 신호를 보내는 용도로 사용합니다. (즉, 값으로 평가되지 않는 표현식의 타입 또는 정상적으로 반환되지 않은 메소드)
    Null 은 모든 참조 타입의 서브타입입니다. (즉, AnyRef 의 모든 서브 타입)
    예약어 null 로 식별되는 단일 값을 갖습니다.
    Null 은 주로 다른 JVM 언어와의 상호 운용성을 위해 제공되며 스칼라 코드에서는 거의 사용되지 않아야 합니다. (뒤에 대안에 대하여)
     */
  })
}

