package com.iamshekhargh.mypizzaapp.repo

import com.iamshekhargh.mypizzaapp.models.request.SendPhoneNumberRequestModel
import com.iamshekhargh.mypizzaapp.retrofit.ApiEndpoints
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PizzaDeliveryRepo @Inject constructor(
    val scope: CoroutineScope,
    private val api: ApiEndpoints
) {

    private val repoChannel = Channel<FirstFragEvent>()
    val repoChannelFlow = repoChannel.receiveAsFlow()

    suspend fun logIn(uId: String, pwd: String) {

    }

    suspend fun loadResourcesInitialStart() {
        scope.launch {
            val aa = async { api.downloadBasicResources() }
            val a = api.downloadBasicResources().awaitResponse()
            repoChannel.send(
                FirstFragEvent.FirstFragResourcesLoaded(
                    "this returned ${
                        a.body().toString()
                    }"
                )
            )
            repoChannel.send(FirstFragEvent.FirstFragResourcesLoaded("this returned ${aa.await()}"))
        }
    }

    fun sendPhoneNumber(phoneNumber: String) {
        scope.launch {
            val response = api.sendPhoneNumberNew(SendPhoneNumberRequestModel(phoneNumber))
            if (response.isSuccessful) {
                val body = response.body()
                //Mobile Number successfully sent.

            } else {
                // Try Again now or later.
            }
        }
    }

    fun requestDashboardInformation() {
        scope.launch {
            val reponse = api.requestDashboardInformation()
        }
    }
}

sealed class FirstFragEvent {
    // this string will be replaced by response .
    data class FirstFragResourcesLoaded(val firstResponse: String) : FirstFragEvent()
}


// Old method
//            val response = api.sendPhoneNumber(phoneNumber).awaitResponse()
//            res.enqueue(object : CustomCallback<SendPhoneNumberRequestModel>() {
//                override fun onDataArrived(t: SendPhoneNumberRequestModel) {
//
//                }
//
//                override fun onError(error: String) {
//
//                }
//
//            })