
fun main() {
    val mv = MyView(3) // 1 출력
    val c = C()
    c.f() // A B 출력
}

// <상속> : 클래스 헤더의 콜론(:) 뒤에 상위타입 선언 ----------------------------------------------------
// 1. 상위타입 선언 X : Any(최상위 클래스)가 상속됨 - equals(), hashCode(), toString() 만 있음
class Example1 // 암시적인 Any 상속
class Example2 : Any() // 명시적인 Any 상속

// 2. 상위타입 선언 O
// 예시1) 자식클래스에 기본생성자가 있는 경우
open class Base1(p: Int) // open : 상속/오버라이드 허용을 위해 반드시 필요 (↔ final(default))
class Derived1(p: Int) : Base1(p)

// 예시2) 자식클래스에 기본생성자가 없는 경우 -> 각 보조생성자에서 super 키워드로 초기화해주어야 함
open class View(num: Int) {
    init {
        println(num)
    }
}
class MyView : View {
    constructor() : super(1)
    constructor(n: Int) : this() // constructor() 호출
}

// <메소드 오버라이딩> ------------------------------------------------------------------------------
open class Base2 {
    open fun v() {} // 오버라이딩 될 메소드 : open
    fun nv() {}
}
class Derived2() : Base2() {
    override fun v() {} // 오버라이딩 된 메소드 : override
}

// <프로퍼티 오버라이딩> : 메소드와 유사 ----------------------------------------------------------------
open class Base3 {
    open val x: Int = 0 // 오버라이딩 될 프로퍼티
}
class Derived3 : Base3() {
    override val x: Int = 3 // 오버라이딩 된 프로퍼티
}

// <오버라이딩 규칙> : 중복된 함수를 상속받은 경우, 오버라이딩 및 구현을 제공해야 함 ----------------------------
open class A {
    open fun f() {println("A")}
    fun a() {println("a")}
}
interface B { // kotlin 에서 interface 는 구현부 작성 가능
    fun f() {println("B")} // 상속 제어 변경자(final, open, abstract) 사용 X, final 로 변경 불가
    fun b() {} // 본문이 없으면 자동으로 추상 멤버가 됨 (abstract 추가할 필요 X)
}
class C : A(), B { // extends A, implements B. 이중 상속 불가
    override fun f() { // 중복된 함수
        super<A>.f()
        super<B>.f()
    }
}

// <추상 클래스> -------------------------------------------------------------------------------------
abstract class AbsClass { // open 필요 X
    abstract fun f() // 구현부 불가능, open 필요 X
}
class MyClass() : AbsClass() {
    override fun f(){} // 반드시 구현 필요
}
