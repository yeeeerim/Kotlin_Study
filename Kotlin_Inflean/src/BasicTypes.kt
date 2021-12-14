
/*
 <숫자>
 - Kotlin 에서 Number 는 클래스
 - char 가 숫자가 아님
 - 8진수를 지원하지 않음
 - 숫자 사이에 '_' 삽입 가능 (ex. 1_000_000)
 */


// Char 는 숫자가 아님
fun check(c: Char) {
    // if(c==1) {} 오류
    if(c=='a') {} // ok

    print('0'.toInt()) // print 48
}

fun main() {

// Explicit Conversions : 작은 타입에서 큰 타입으로의 대입이 안 됨. 명시적 변환 필요
    val a: Int = 1
    // val b: Long = a 오류
    val b: Long = a.toLong() // ok


// <배열> : Array 클래스
    var array1: Array<String> = arrayOf("0","1","2","3","4") // 라이브러리 함수로 생성
    var array2 = Array(5, {i -> i.toString()}) // 팩토리 함수로 생성

    println(array2.get(1))
    println(array1.get(0)) // get, set 으로 접근
    println(array1[0]) // [] 연산자 가능
    println(array1.size)


// <특별한 Array 클래스> : IntArray, ShortArray, ... (Primitive 타입의 박싱 오버레이를 없애기 위함)
// Array 클래스와 동일하게 get, set, [] 으로 접근
    val x: IntArray = intArrayOf(1,2,3)
    x[0] = 7
    println(x.get(0))


// <문자열> : String 클래스
    var y: String = "Kotlin"
    println(y.get(0))
    println(y[0])
    println(y.length)
    for(c in y) print(c)


// <문자열 리터럴>
    // 1. escaped string
    val s1 = "Hello, World!\n"

    // 2. raw string
    val s2 = """
이것은 코를린의
raw String
입니다.
    """
    println(s2)
}