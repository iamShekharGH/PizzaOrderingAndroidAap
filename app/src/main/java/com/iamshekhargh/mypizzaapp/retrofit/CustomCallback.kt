package com.iamshekhargh.mypizzaapp.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class CustomCallback<T> : Callback<T> {

    abstract fun onDataArrived(t: T)

    abstract fun onError(error: String)

    override fun onResponse(call: Call<T>, response: Response<T>) {
        response.body()?.let { onDataArrived(it) }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onError("onFailure\t::" + t.message)
        t.printStackTrace()
    }

}