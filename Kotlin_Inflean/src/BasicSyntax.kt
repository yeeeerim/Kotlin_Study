import java.lang.Integer.parseInt

fun sum(a: Int, b: Int) = a+b
fun maxOf(a: Int, b: Int) = if(a>b) a else b



// nullable : 값이 null일 수 있는 경우 타입에 nullable 마크를 명시해야 함
fun getStringLength(obj: Any): Int? {
    if(obj is String) {
        // 'obj' 가 자동으로 String 타입으로 변환됨
        return obj.length
    }

    return null
}

fun printProduct(arg1: String, arg2: String) {
    val x:Int? = parseInt(arg1)
    val y:Int? = parseInt(arg2)

    if(x!=null&&y!=null) {
        println(x*y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun describe(obj: Any): String =
    when (obj) {
        1   -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String  -> "Not a string"
        else    -> "Unknown"
    }

fun main() {
    // val : 읽기 전용 변수
    val a:Int = 1
    val b = 2 // type 추론

    // var : Mutable 변수
    var x = 5
    x += 1

    // 문자열 템플릿
    var c = 1
    val s1 = "c is $c"

    c = 2
    val s2 = "${s1.replace("is", "was")}, but now is $c"

    // ranges
   for(x in 1..5) {
       print(x)
   }
    println()

    val z = 3
    if(z in 1..10) {
        println("fits in range")
    }

    // collections
    val items = listOf("apple", "banana", "kiwi")
    for(item in items) {
        println(item)
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
        .filter{it.startsWith("a")}
        .sortedBy { it }
        .map{it.uppercase()}
        .forEach{println(it)}

    println(sum(2,3))
    println(maxOf(1,2))
    println(s2)
    printProduct("2","3")
    println(describe(1))
}

