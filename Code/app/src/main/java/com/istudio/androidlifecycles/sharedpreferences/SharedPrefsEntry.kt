package com.istudio.androidlifecycles.sharedpreferences

interface SharedPrefsEntry<T> {
    fun set(value: T)
    fun get(): T
}