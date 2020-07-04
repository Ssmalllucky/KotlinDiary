package com.kotlindiary.main

import javax.security.auth.Subject

//类定义
//Kotlin中的类可以有一个构造器，以及一个或多个次构造器，主构造器是类的一部分，位于类名称之后
class Runoob(val firstName : String){

    var mFirstName : String = "";

    //非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
    lateinit var subject: Subject

    //主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
    //如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中
    // 代理另一个构造函数使用 this 关键字：
    constructor(firstName :  String,age : Int) : this(firstName) {

        fun printTest() {
            println("FirstName is ${firstName}")
        }
        printTest()
    }




    fun foo(){  //成员函数
        println("Foo")
    }

    //属性定义
    var name : String = "";
    var url : String = "";
    var city : String = "";

    var lastName : String = "Jack"
    get() = field.toLowerCase()
    set

    var num : Int = 100
    get() = field
    set(value){
        if (value <= 10) {
           field = value
        } else {
            field = -1
        }
    }

    var heint : Float = 140.4F
        private set //如果private设置为set，则不能通过实例化的形式赋值

}