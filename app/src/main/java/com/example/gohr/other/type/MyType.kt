package com.example.gohr.other.type


/**
 * Saidmurod Turdiyev writes this for All Project (SMT)
 */

typealias emptyBlock = () -> Unit
typealias sendOneParametreBlock <T> = (T) -> Unit
typealias returnParametreBlock <T> = () -> T
typealias sendAndReturnParametreBlock <T> = (T) -> T
typealias sendAndReturnDifferentParametreBlock <T, K> = (T) -> K
