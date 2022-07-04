//package com.truongdc21.koinv2.test
//
//import android.util.Log
//import org.koin.core.annotation.Factory
//import org.koin.core.annotation.Module
//import org.koin.core.annotation.Single
//
//@Module
//@Factory
//class Student(val couse : schoolCouse ,  val sfriend: Friend) {
//
//    fun beSmart() {
//        couse.study()
//        sfriend.hangout()
//    }
//}
//
//@Module
//@Single
//class schoolCouse(){
//    fun study (){
//        Log.d("x2" ,"I am studying")
//    }
//}
//
//@Module
//@Factory
//class Friend(){
//    fun hangout (){
//        Log.d("x2" ,"We re hangout")
//    }
//}