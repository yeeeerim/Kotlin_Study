import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent


fun main() {

// <Object>
// : 어떤 class 에서 조금 변경된 객체를 생성할 때 or 새로운 subclass 의 명시적인 선언 없이 객체 생성할 때


/*
 <Object Expressions> : Java 익명 객체와 비슷
 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ (ex) ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 | window.addMouseListener(object : MouseAdapter() {    |
 |    override fun mouseClicked(e: MouseEvent){ }       |
 |    override fun mouseEntered(e: MouseEvent) { }      |
 | })                                                   |
 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 */

    class MyRunnable : Runnable {
        override fun run() {
            println("hello")
        }
    }

    val t1 = Thread(MyRunnable())
    t1.run()

    // ▼ object 사용 시

    val t2 = Thread(object : Runnable {
        override fun run() {
            println("hello")
        }
    })
    t2.run()

    /*
      상속 - 슈퍼 타입에 생성자가 있으면 반드시 값을 전달해주어야 하고, 슈퍼 타입이 여러 개인 경우 ','로 구분
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡ (ex) ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      | open class A(x: Int) {           |
      |   public open val y: Int = x     |
      | }                                |
      | interface B {}                   |
      | val ab: A = object: A(1), B {    |
      | override val y = 15              |
      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    }
     */

    // 상속 없는 경우
    val adHoc = object {
        // 바디 내용이 없어도 됨 (중괄호는 필수)
        var x: Int = 11
        var y: Int = 22
    }
    println("${adHoc.x}, ${adHoc.y}")

    // 특징
    // 1) 익명 객체의 코드는 enclosing scope 의 변수를 접근할 수 있음
    // 2) Java 와 다르게 final variables 제약 조건이 없음
    fun countClicks(window: JComponent) {
        var clickCount = 0 // Java 에서는 final 이어야 함
        var enterCount = 0 // Java 에서는 final 이어야 함
        window.addMouseListener(object : MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) { clickCount++ }
            override fun mouseEntered(e: MouseEvent?) { enterCount++ }
        })
    }
}


// <Object Declarations> : 싱글턴(Singleton) 패턴
// 특징
// 1) object 키워드 뒤에 항상 이름이 있어야 함
// 2) object declaration 은 object expression 이 아님 -> 할당 구문의 우측에 사용될 수 없음
// 3) 슈퍼 타입을 가질 수 있음 (상속 가능) -> ex) object obj : MouseAdapter() {}
class DataProvider
object DataProviderManager { // DataProviderManager.registerDataProvider(...) 로 접근
    fun registerDataProvider(provider: DataProvider) {}
    val allDataProviders: Collection<DataProvider>?
        get() {return null}
}



// <Companion Object> : 동반자 객체 = 싱글턴 + Class method (static) -> Kotlin 에는 static 이 없음
// - companion object 의 멤버가 다른 언어의 static 멤버처럼 보일 수 있지만 아님 (실제 객체의 멤버임)
class My_Class {
    companion object Factory { // 이름 생략 가능 -> My_Class.Companion 으로 객체 접근 가능
        fun create() : My_Class = My_Class()
    }
}
val instance = My_Class.create() // My_Class.Factory.create() 로 할 필요 없음

interface Factory<T> {
    fun create() : T
}
class My_Class2 {
    companion object : Factory<My_Class2> { // 슈퍼클래스도 가질 수 있음
        override fun create() : My_Class2 = My_Class2()
    }
}


/**
 * <Object expressions vs. Object declarations vs. Companion object>
 * 1. expressions 는 즉시 초기화되고 실행되지만,
 * 2. declarations 는 나중에 초기화되고, (최초 접근 시)
 * 3. companion object 는 클래스가 로드될 때 초기화됨 (java 의 static initializer 와 매칭)
 */