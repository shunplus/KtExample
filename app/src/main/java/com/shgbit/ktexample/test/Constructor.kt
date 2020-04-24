package com.shgbit.ktexample.test

/**
 * Created by xushun on  2020/3/14 23:40.
 * Email：shunplus@163.com
 * Des：
 */
class User(id:Int) {
    var id:Int
    var name :String

    init {
        this.id=1;
        this.name="";
    }

    constructor(id:Int,name:String):this(id){ //次构造函数,必须调用主构造函数
        this.id=id;
        this.name=name;

    }
}