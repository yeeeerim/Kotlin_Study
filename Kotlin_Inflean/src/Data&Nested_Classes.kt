
fun main() {

// <Data Classes> : 데이터는 보유하지만 아무것도 하지 않는 클래스
    /*
        1) 아래 기능들을 컴파일러가 자동으로 생성해줌 (body 에서 선언한 프로퍼티는 생성되지 X)
        - equals()
        - hashCode()
        - copy()
        - toString()

        2) abstract, open, sealed, inner 불가능
     */
    data class User(val name: String, val age: Int)

    val u1 = User("yerim", 23)
    println(u1) // User(name=yerim, age=23) -> toString() 함수가 자동으로 실행된 것.(일반 class 는 주소를 출력함)


    // data class 를 파라매터가 있는 생성자로 만들었지만,
    // 없는 생성자가 필요한 경우 모든 프로퍼티에 기본 값을 설정해주면 됨
    data class Car(val color: String="", val num: Int=0)
    val c1 = Car()
    val c2 = Car("Black")
    val c3 = Car("Black",1234)
    val c4 = Car(num=1234)
    val c5 = Car(color="Black", num=1234)


    // 1. 복사(copy()) : 객체의 기존 값들은 유지하고, 일부 값만 고쳐 새로운 객체를 만들고 싶은 경우
    val u2 = u1.copy(age=24) // 객체 u1을 u2에 복사하되, age 만 24 로 변경
    println(u2) // User(name=yerim, age=24)

    // 2. Destructuring Declarations
    val jane = User("Jane", 35)
    val (name, age) = jane // val name = jane.name val age = jane.age 를 최소화
    println("$name, $age years of age")


// <Standard Data Classes> : 스탠다드 라이브러리에서 제공하는 클래스 => Pair, Triple
    val pair = Pair("Jane", 35) // pair.first, pair.second 로 접근
    val triple = Triple("Jane", 35, "여")

}


// <Nested Classes> : 중첩 클래스

class Outer { // 외부 클래스
    private val bar: Int = 1

    class Nested { // 중첩 클래스
       // Outer 클래스의 프로퍼티 접근 불가능
       fun foo() = 2
    }

    inner class Inner { // 내부 클래스
        fun foo() = bar // Outer 클래스의 프로퍼티 접근 가능
    }
}
val demo1 = Outer.Nested().foo() // == 2
val demo2 = Outer().Inner().foo() // == 1  ※ Inner class 는 Outer 클래스의 객체가 필요하기 때문에 괄호 필요


/* <Anonymous inner classes> : 익명 내부 클래스
    - 객체 표현식을 이용해서 익명 내부 클래스의 인스턴스를 생성할 수 있음
    ====================================================================
    mSearchEditText.setOnClickListener(object: View.OnClickListener {
        override fun onClick(v: View?){

        }
    })
    ====================================================================

    ▼ Functional java interface 인 경우 접두어에 인터페이스 이름을 사용하여 람다식으로 표현 가능

    ====================================================================
    mSearchEditText.setOnClickListener(View.OnClickListener {
        v -> ...
    ====================================================================
*/
