package com.shgbit.ktexample.test

/**
 * Created by xushun on  2020/3/14 23:53.
 * Email：shunplus@163.com
 * Des：
 */
class GetSet (int: Int){
    var id:Int=0;
    var name :String="wwee"
        get()=name
      set(value) {
          field=value
      }


    constructor(id: Int, name: String):this(id) {
        this.id = id
        this.name = name
    }
}


class Test(name: String, name1: String){
    private var _name : String=name;
    var name = name1
        get() = _name
    set(value) {
        field = value
    }
}


fun main(){

    var  test=Test("weee", "")
    println(test.name)

    var user2=User2("张三","很美")
    
   var (name1,_)=user2;

    println(user2.name)


}