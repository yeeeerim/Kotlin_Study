import pack.print.print2
// import pack.print.* 혹은 import pack.* 가능
// 함수 이름이 충돌나는 경우 'as' 키워드로 로컬 리네임 가능. ex) import pack.print.print2 as ppp2


fun main() {

// <Package>
   print1() // import 필요 X
   print2()  // import 필요 O


// <Jump and Return> : break, continue, return
   // 1. Label 로 break
   loop@ for (i in 1..10) {
      println("--- i: $i ---")

      for(j in 1..10) {
         println("j: $j")
         if(i+j>12) {
            break@loop // 바로 바깥 for 문이 아닌 loop label 이 달린 for 문이 break
         }
      }
   }

   // 2, Label 로 continue
   loop@ for(i in 1..10) {
      println("--- i: $i ---")

      for(j in 1..10) {
         if(j<2) {
            continue@loop // 바로 바깥 for 문이 아닌 loop label 이 달린 for 문으로 continue
         }
         println("j: $j")
      }
   }

   ret1()
   ret2()
   print(ret3())
}

// 3. 함수에서 return VS. 람다식에서 return

fun ret1() {
   var ints = listOf(0,1,2,3)
   ints.forEach (
      fun(value: Int) {
         if (value == 1) return // 바로 바깥 함수만 종료됨
         print(value)
      }
   )
   print("End")
}

fun ret2() {
   var ints = listOf(0,1,2,3)
   ints.forEach label@ {
      if(it==1) return@label // label 이 없으면 ret2() 함수가 종료됨 -> @forEach 도 가능
      print(it)
   }
   print("End")
}

// 4. 레이블 return 시 값을 반환할 경우
fun ret3(): List<String> {
   var ints = listOf(0,1,2,3)
   val result = ints.map {
      if (it == 0) {
         return@map "zero" // [return@label + 값] 형태로 사용
      }
      "number $it"
   }
   return result
}



