package com.developer.statedata


import androidx.lifecycle.MutableLiveData

class StateLiveData<T> : MutableLiveData<StateData<T>?>() {
    /**
     * Use this to put the Data on a LOADING Status
     */
    fun postLoading() {
        postValue(StateData<T>().loading())
    }

    /**
     * Use this to put the Data on a ERROR DataStatus
     * @param throwable the error to be handled
     */
    fun postError(throwable: Throwable?) {
        postValue(StateData<T>().error(throwable!!))
    }

    /**
     * Use this to put the Data on a ERROR DataStatus
     * @param error the error to be handled
     */
    fun postError(error: T) {
        postValue(StateData<T>().error(error))
    }

    /**
     * Use this to put the Data on a ERROR DataStatus
     * @param error the error to be handled
     */
    fun postError(error: String) {
        postValue(StateData<T>().error(error))
    }

    /**
     * Use this to put the Data on a ERROR DataStatus
     *
     */
    fun postError() {
        postValue(StateData<T>().error())
    }

    /**
     * Use this to put the Data on a SUCCESS DataStatus
     * @param data
     */
    fun postSuccess(data: T) {
        postValue(StateData<T>().success(data))
    }

    /**
     * Use this to put the Data on a COMPLETE DataStatus
     */
    fun postComplete() {
        postValue(StateData<T>().complete())
    }
}