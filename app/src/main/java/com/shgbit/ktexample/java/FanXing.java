package com.shgbit.ktexample.java;

/**
 * Created by xushun on  2020/3/15 18:25.
 * Email：shunplus@163.com
 * Des：
 */
public class FanXing {

    class Fruit{}

    class Apple extends Fruit{}

    class PanZi<T>{

        public PanZi(T t) {

        }
    }

    //  ?extends 上届通配符
    PanZi<? extends Fruit> panZi=new PanZi<Apple>(new Apple());


}
