import java.lang.Integer.parseInt

fun main() {

// if else 문 (삼항연산자는 無)
    val a=3
    val b=2
    val max1 = if(a>b) a else b // 반드시 else 필요
    val max2 = if(a>b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }


// when 문 : break 가 없어도 있는 것처럼 처리
    var x = 3
    when(x) {
        1 -> println("x==1")
        2 -> println("x==2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }

    // else 문이 반드시 필요한 경우
    var res1 = when(x) {
        100 -> "A"
        90 -> "B"
        80 -> "C"
        else -> "F"
    }

    // else 문이 필요 없는 경우 : boolean 과 같이 모든 조건을 따지는 경우
    var y = true
    var res2 = when(y) {
        true -> "맞다"
        false -> "틀리다"
    }

    // 여러 조건은 콤마(,)를 사용하여 표기
    when(x) {
        0,1 -> println("x==0 or x==1")
        else -> println("otherwise")
    }

    // branch 의 조건문에 함수 or 식 사용 가능
    when(x) {
        parseInt("$x") -> println("s encodes x")
        1+3 -> println("4")
        else -> println("s does not encode x")
    }

    // range 나 collection 에 in or !in 으로 범위 검사 가능
    val validNumbers = listOf(3,6,9)
    val n = 3
    when(n) {
        in validNumbers -> println("n is valid")
        in 1..10 -> println("n is in the range")
        !in 10..20 -> println("n is outside the range")
        else -> println("none of the above")
    }

    // is or !is 로 타입 검사 가능
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix") // String 을 검사한 순간 String 타입으로 "스마트 캐스트"가 적용되어 startWith 사용 가능
        else -> false
    }

    // 인자를 입력하지 않으면, 논리연산으로 처리됨
    when {
//        x.isOdd() -> println("x is odd")
//        x.isEven() -> println("x is even")
//        else -> println("x is funny")
    }


// for 문
    // iterator 을 제공하는 모든 것을 반복 가능
    val collection = listOf(1,2,3)
    collection.iterator()
    for(item in collection)
        print("$item ")
    println()

    // index 를 이용하는 방법
    // 1. indices
    val array1 = arrayOf("가", "나", "다")
    for(i in array1.indices) {
        println("$i: ${array1[i]}")
    }
    // 2. withIndex
    val array2 = arrayOf("가", "나", "다")
    for((index, value) in array2.withIndex()) {
        println("$index: $value")
    }


// while 문 / do-while 문 : Java 와 유사
    while(x>0) {
        x--
    }
    do {
        x--
    } while(x==0) // do 에서 선언한 지역 변수를 while 문에서 사용할 수 있음 (Java 와의 차이)
}