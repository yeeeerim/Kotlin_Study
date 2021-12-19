
fun main() {

// <인스턴스 생성> : new 키워드 無, 일반 함수처럼 호출
   val p = Person("yerim")

}

// <클래스> -----------------------------------------------------------------------------------------
class Invoice(data: Int) { // 이름(헤더)
 // 바디
}
class Empty // 헤더, 바디 생략 가능


// <기본생성자> : 클래스 별로 최대 1개 가질 수 있음 --------------------------------------------------------
class Person constructor(name: String) { // 어노테이션이나 접근지정자가 없을 때, constructor 키워드 생략 가능
    init { // 초기화 블록 : 기본생성자의 매개변수는 init 블록 안에서 사용 가능
        println("Person initialized with value $name")
    }
    val personKey = name.uppercase() // 기본생성자의 매개변수는 프로퍼티 초기화 선언에도 사용 가능
}

// 프로퍼티 선언 및 초기화를 기본생성자의 헤더에서 수행함으로써 간결한 구문으로 사용 가능
class Customer(val firstName: String, val lastName: String) {

}

// <보조생성자> : 클래스 별로 여러 개 가질 수 있음 ---------------------------------------------------------
class Child(val name: String) {
    // 클래스가 기본생성자를 가지고 있다면, 각각의 보조 생성자들은 기본생성자를 위임해주어야 함 -> this 이용
    constructor(name: String, parent: Person) : this(name) { // 직접적 위임 : 기본생성자에 위임

    }
    constructor() : this("default", Person("")) { // 간접적 위임 : 다른 보조생성자에 위임임

   }
}

// <생성된(generated) 기본생성자> : 기본/보조생성자를 선언하지 않으면 자동으로 생성됨 - 매개변수 無, public -------
// 생성된 기본생성자가 public 이 아니어야 하면, 빈 기본생성자를 선언해야 함
class DonCreateMe private constructor() {
}

/* <클래스 맴버> : 클래스가 포함할 수 있는 것 -------------------------------------------------------------
 - 생성자, init 블록
 - 함수
 - 프로퍼티
 - 중첩 혹은 이너 클래스
 - 객체 선언
*/