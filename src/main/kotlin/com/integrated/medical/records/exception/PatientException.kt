package com.integrated.medical.records.exception

import java.lang.Exception
import java.lang.RuntimeException

class PatientUpdateException : RuntimeException {
    var args: Array<out String>? = null


    constructor(message: String) : super(message)
    constructor(ex: Exception) : super(ex)
    constructor(message: String, ex: Exception) : super(message, ex)

    constructor(message: String, vararg args: String) : super(message) {
        this.args = args
    }
}