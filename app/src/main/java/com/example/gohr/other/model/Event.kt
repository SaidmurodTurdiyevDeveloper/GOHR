package com.example.gohr.other.model

import com.example.gohr.other.type.sendOneParametreBlock


/**
 * Saidmurod Turdiyev writes this for All Project (SMT)
 */

open class Event<T>(private val content: T, val text: String = "", val block: sendOneParametreBlock<T>? = null) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}
