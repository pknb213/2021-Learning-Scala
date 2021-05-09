object Trait extends App {
  // Trait : 클래스 간 인터페이스와 필드를 공유하는데 사용합니다.
  // 클래스와 객체는 트레잇을 확장할 수 있지만 트레잇을 인스턴스화 할 수 없으므로 매개변수가 없습니다.
  // 제네릭 타입과 추상 메서드로 유용하게 사용
  trait Iterator[A] {
    def hashNext: Boolean
    def next(): A
  }
  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0
    override def hashNext: Boolean = current < to
    override def next(): Int = {
      if (hashNext){
        val t = current
        current += 1
        t
      } else 0
    }
  }
  val iterator = new IntIterator(10)
  println({
    iterator
  })
  println({
    iterator.next()
  })
  println({
    iterator.next()
  })
  println({
    iterator.next()
  })

  // Subtyping : 특정 트레잇이 필요한 곳에 해당 트레잇의 서브타입을 대신 사용할 있숩니다.
  // trait Pet 에는 Cat, Dog 의 생성자에서 구현된 추상필드 name 이 있습니다.
  // 마지막 줄에서 pet.name 을 호출하고 있는데, 이것은 Pet 의 서브타입에서 구현되어야 합니다.
  import scala.collection.mutable.ArrayBuffer

  trait Pet{
    val name: String
  }
  class Cat(val name: String) extends Pet
  class Dog(val name: String) extends Pet

  val dog = new Dog("Husky")
  val cat = new Cat("Nayang")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))
}
