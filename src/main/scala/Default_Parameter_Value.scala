object Default_Parameter_Value extends App {
  // Default Parameter Value : 파라미터에 기본 값을 부여해 호출자가 해당 파라미터를 생략할 수 있는 기능 제공.
  /*  Java Version
  public class HashMap<K,V> {
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75;

    public HashMap<Map<? extends K, ? extends V> m);
    // 기본 크기가 16이고 로드팩터가 0.75인 HashMap 생성
    public HashMap();
    // 기본 로드 팩터가 0.75인 새로운 HashMap 생성
    public HashMap(int initialCapacity);
    public HashMap(int initialCapacity, float loadFactor);
   */

  // 위의 자바에서 스칼라 아래 코드처럼 코딩할 수 있다.
  class HashMap[K,V](initialCapacity: Int = 16, loadFactor: Double = 0.75) {
  }
  // 기본 값 사용
  val m1 = new HashMap[String, Int]
  // 초기 크기는 20, 로드팩터는 기본 값
  val m2 = new HashMap[String, Int](20)
  // 둘 모드를 오버라이드
  val m3 = new HashMap[String, Int](20, 0.8)
  // 이름을 지정한 인수를 통해 로드팩터만을 오버라이드
  val m4 = new HashMap[String, Int](loadFactor=0.8)
  println({
    m1
  })
  println({
    m2
  })
  println({
    m3
  })
  println({
    m4
  })
}
