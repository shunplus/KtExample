package com.shgbit.ktexample.util
import android.content.Context
import android.content.SharedPreferences
import com.shgbit.ktexample.app.HobbyApplication
import java.lang.IllegalStateException
import kotlin.reflect.KProperty

class SpUtil<T>(val name:String, private val default: T){
    private val prefs: SharedPreferences by lazy { HobbyApplication.instance.getSharedPreferences(name,
        Context.MODE_PRIVATE) }

    operator fun getValue(thisRef:Any?,property:KProperty<*>):T{
        return getSharedPrefences(name,default)
    }

    operator fun setValue(thisRef:Any?,property:KProperty<*>,value:T){
         putSharedPrefences(name,value)
    }



    private fun putSharedPrefences(name:String,value:T) = with(prefs.edit()){
        when(value){
            is Long -> putLong(name,value)
            is String -> putString(name,value)
            else -> throw IllegalStateException("This is not saved")
        }
    }.apply()

    private fun getSharedPrefences(name:String,default: T): T = with(prefs){
        val result: Any = when(default){
            is Long -> getLong(name,default)
            is String -> getString(name,default)?:""
            else -> throw IllegalStateException("This is not saved")
        }
        return result as T
    }
}