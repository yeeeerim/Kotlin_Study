
fun main() {
    var obj = Address()
    println(obj.name) // name 의 get() 이 실행됨
}

/*
 <프로퍼티 문법>
 | var 이름: [타입] = [초기값]  | -> 초기값을 통해 타입을 추론할 수 있는 경우 타입 생략 가능
 | [getter]                  |
 | [setter]                  |
 */

// 클래스는 프로퍼티를 가질 수 있음
class Address {
// <var(mutable) 프로퍼티> : default getter/setter 를 사용한 경우 명시적인 초기화 필요
    var name: String = "Kotlin"
        get() { return field + "!!!" } // getter 재정의
        set(value) { field = value } // setter 재정의
    // var allByDefault: Int? -> ✔ 오류 발생 : 초기화 X


// <val(read-only) 프로퍼티> : setter 가 없음, default getter 를 사용한 경우 명시적인 초기화 필요
    val city: String = "Seoul"


// <Custom accessors> (getter/setter 재정의)
    // 1. getter
    val isNull: Boolean // kotlin 1.1 부터는 타입 추론 가능한 경우 생략 가능
        get() = this.name == null // name 이 null 이면 true 반환
    // 2. setter
    var stringRepresentation: String
        get() = this.toString()
        set(value) { value } // 관습적으로 파라메터의 이름이 value 지만, 변경 가능


// <가시성 변경 or 어노테이션이 필요한 경우> : body 생략 가능능
    var setterVisibility: String = "abc"
        private set
    var setterWithAnnotation: Any? = null
        @Inject set

    annotation class Inject


// <Backing Fields>
    // 생성 조건 1) accessor 중 1개라도 기본 구현을 사용하는 경우
    // 생성 조건 2) custom accessor 에서 field 식별자를 참조하는 경우
    var count = 0
        set(value) {
            if(value >= 0) field = value // field : 프로퍼티의 accessor 에서만 사용 가능
        }

    // 아래의 경우 backing field 를 생성하지 않음
    val isEmpty: Boolean
        get() = this.name == ""


}
fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name

    return result
}