package com.developer.statedata

import java.util.*

class StateData<T> {
    var status: DataStatus
        private set
    private var data: T?
    private var error: Throwable?
    fun loading(): StateData<T> {
        status = DataStatus.LOADING
        data = null
        error = null
        return this
    }

    fun success(data: T): StateData<T> {
        status = DataStatus.SUCCESS
        this.data = data
        error = null
        return this
    }

    fun error(error: Throwable): StateData<T> {
        status = DataStatus.ERROR
        data = null
        this.error = error
        return this
    }

    fun error(): StateData<T> {
        status = DataStatus.ERROR
        data = null
        error = null
        return this
    }

    fun complete(): StateData<T> {
        status = DataStatus.COMPLETE
        return this
    }

    fun getData(): T {
        return data!!
    }

    fun getError(): Throwable {
        return error!!
    }

    enum class DataStatus {
        CREATED, SUCCESS, ERROR, LOADING, COMPLETE
    }

    init {
        status = DataStatus.CREATED
        data = null
        error = null
    }
}