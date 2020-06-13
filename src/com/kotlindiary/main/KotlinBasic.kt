package com.kotlindiary.main


/*********************** Kotlin基本语法 ****************************/
fun main() {
    println("Hello")
//    vars(1,2,3,4,5)
//    lambdaTest()
//    testnull()
//    stringModel()
    println(intervalFunctionDownTo())
}

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