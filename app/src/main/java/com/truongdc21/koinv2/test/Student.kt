package com.truongdc21.koinv2.test

import android.util.Log

class Student(val couse : schoolCouse ,  val sfriend: Friend) {

    fun beSmart() {
        couse.study()
        sfriend.hangout()
    }
}

class schoolCouse(){
    fun study (){
        Log.d("x2" ,"I am studying")
    }
}

class Friend(){
    fun hangout (){
        Log.d("x2" ,"We re hangout")
    }
}