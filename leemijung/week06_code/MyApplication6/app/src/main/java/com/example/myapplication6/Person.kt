package com.example.myapplication6

import java.io.Serializable

class PersonFromServer (
    var id:Int?=null,
    var name:String?=null,
    var age:Int?=null,
    var intro:String?=null
):Serializable // 상속아님