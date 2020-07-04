package com.kotlindiary.main

open class SimpleObj() {
    open fun f(){
        println("Hello")
    }

    constructor(firstCons : String) :this(){

    }

    //创建不同的构造方法，如果继承于默认构造方法，可以使用代理
    constructor(firstCons: String,nums : Int) :this(firstCons){
        println("${firstCons}")
    }

    //内部类写法
    private val length: Int = 5
    private val desc: String = "Rectangle";

    inner class Inner {
        fun getLength() = length
        fun innerTest() {
            var innerDesc = this@SimpleObj
            println("内部类可以引用外部类的成员，例如：" + innerDesc.desc)
        }
    }
}