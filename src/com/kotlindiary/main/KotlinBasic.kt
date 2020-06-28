package com.kotlindiary.main


/*********************** Kotlin基本语法 ****************************/

//函数定义
fun sum(a: Int, b: Int): Int {
    return a + b
}

//函数体写法
fun sumFunction(a: Int, b: Int): Int = a + b

//无返回值的函数(类似于Java中的Void,也可以省略Unit)
fun sumFunctionNoReturn(a: Int, b: Int): Unit {
    println(a + b)
}

//可变长参数函数
fun vars(vararg v: Int) {
    for (vt in v) {
        println(vt)
    }
}


//lambda表达式实例
fun lambdaTest() {
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))
}

//定义常量与变量
//定义可变变量
//var <标识符> :<类型> = <初始化值>

//定义不可变变量: val关键字，只能赋值一次的变量
//val <标识符> : <类型> = <初始化值>

fun valAndVar() {
    val a: Int = 1
    val b = 1 // 系统自动推断变量类型为Int
    val c: Int   //如果不在声明时初始化则必须提供变量类型
    c = 1

    var x = 5   //系统自动推断变量类型为Int
    x += 1
}

//NULL检查机制
//Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式:
//字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
fun testnull() {
    var ageStr: String? = null      //类型后面加？表示类型可空
    val ages = ageStr!!.toInt()     //若ageStr为空则会抛出空指针异常
    val ages1 = ageStr?.toInt()     //空指针检查未通过，返回NULL
    val ages2 = ageStr?.toInt() ?: -1   //  若ageStr为空则返回-1
    println(ages)
//    val names:name
}

//字符串模板
fun stringModel(){
    var a = 1
    val s1 = "I was ${a}"
    a = 2
    val s2 = "${s1}, now I am ${a}"
    println(s2)
}

//类型检测以及自动类型转换
//Any是Kotlin中所有类都会继承的基类，类似于Java中的Object类
fun getTypeAndTypeChangeAuto(obj : Any):Int?{
    if(obj is String){
        //做过类型判断以后，obj会被系统自动转为String类型
        return obj.length
    }
    return null
}


//区间用法
//顺序
fun intervalFunctionIn(){
    var time1 = System.currentTimeMillis()
    for(i in 1..10){    //等同于1<=i;i<=10;
        //打印一秒后退出循环
        if(System.currentTimeMillis() - time1 == 1000L){
            break
        }
        println(i)
    }
}

//倒序
fun intervalFunctionDownTo(){
    for(i in 10 downTo 1){
        println(i)
    }
    //使用step指定步长
    for(i in 11 downTo 1 step 2){
        println(i)
    }
}

/**
 * Kotlin基本数据类型
 *
 * Double   8 byte
 * Float    4 byte
 * Long     8 byte
 * Int      4 byte
 * Short    2 byte
 * Byte     1 byte(8 bit)
 */

//Kotlin不支持8进制数据
fun baseDataTypes(){
    val numInt = 100_000_000  //使用下划线使数字常量更容易阅读
    val numFloat = 100_0000F
    val numLong = 100_000L

    println(numInt)

    //Kotlin 中比较两个数字
    //在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
    //经过装箱（将基本数据类型变成了包装器类型），创建了两个不同的对象
    val numIntA : Int? = numInt
    val numIntB : Int? = numInt

    println("===: " + (numIntA === numIntB))

    println("==: " + (numIntA == numIntB))
}

fun typeCovert(){
    //由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。
    // 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
    val b: Byte = 1
//    val i: Int = b  //错误
    val i: Int = b.toInt()  //正确
}

fun bitOperator(){

}

//字符：和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，
// Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。
//比如 var c : Char c = 1，会报错

//数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，
// 由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便
// 的获取或者设置数组对应位置的值。 数组的创建两种方式：一种是使用函
// 数arrayOf()；另外一种是使用工厂函数。如下所示，我们分别是两种方
// 式创建了两个数组：
fun testArray(){
    val a = arrayOf(1, 2, 3)
    val b = Array(3, { i -> (i * 2) })
    println(b[2])
}

//字符串
fun testString(){

    //多行字符串写法,在后面加.trim()会把不在字符串内容之间的空格全部去掉，
    //.trimMargin()会把不在字符串所在行的空格全部去掉，
    //.trimIndent()会把字符串之间的空格全部去掉，仅保留字符内容中的换行
    val text = """
        
        Hello,
        world
    """.trimIndent()
    println(text)

}


/*********************** Kotlin条件控制 ***********************/
fun conditionControl(a:Int,b:Int){
//    val max = if (a > b) a else b
//    println(max)
    //函数体写法
    val maxFunction  = if (a > b){
        println(a)
        a
    } else {
        println(b)
        b
    }
}

//使用in运算符来检测某个数字是否在指定区间内，区间格式是x..y
fun testInterval(){
    val x = 8
    if(x in 1..9){
        println("True")
    } else {
        println("False")
    }
}

//When表达式
//When表达式类似于其他语言中的switch语句，不同的是，Kotlin中的when表达式可以用函数体来表示
fun testWhen(x:Int){
    //最简单的使用方式
    when (x){
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> println("x is not valid")
    }

    //如果有很多分支需要相同的处理，可以把分支条件放在一起，用逗号隔开
    when (x) {
        0,1 -> println(" x 有效")
        else -> println(" x 无效")
    }

    //也可以检测一个值在或者不在一个区间或者集合中
    when (x) {
        in 1..10 -> println("x 在区间中")
        !in 11..20 -> println("x 不在区间中")
        else -> println("x 是无效数字")
    }

    //还可以通过when表达式来检测一个值是（is）或者不是(!is)一个特定类型的值
//    when (x) {
//        is String -> true
//        else -> false
//    }

}

/*********************** Kotlin循环控制 ***********************/
//kotlin中的for循环可以对任何提供迭代器的对象进行遍历，语法如下：
// for (item in collection) println(item)

//P.S：这种“在区间上遍历”会编译成优化的实现而不会创建额外的对象
//使用库函数withIndex

fun testWithIndex(){
    val array = Array(5,{i -> i+1}) //初始化数组
    for ((index,value) in array.withIndex()){
        println("index is ${index},value is ${value}")
    }
}

fun testTagReturn(){
    val ints = arrayOf(1,2,3,4,5)
    ints.forEach {
        if (it == 3) return@forEach
        println(it)
    }
}

//为了方便debug，将main方法写在最下面
fun main() {
    println("Hello World")
//    vars(1,2,3,4,5)
//    lambdaTest()
//    testnull()
//    stringModel()
//    println(conditionControl(3,1))
    testTagReturn()
}

