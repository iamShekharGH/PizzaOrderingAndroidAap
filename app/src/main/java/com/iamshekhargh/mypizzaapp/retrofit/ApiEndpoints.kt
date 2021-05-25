package com.iamshekhargh.mypizzaapp.retrofit

import com.iamshekhargh.mypizzaapp.models.request.SendPhoneNumberRequestModel
import com.iamshekhargh.mypizzaapp.models.response.SendDashboardResponseModel
import com.iamshekhargh.mypizzaapp.models.response.SendPhoneNumberResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoints {

    companion object {
        const val BASE_URL = ""
    }

    suspend fun downloadBasicResources(): Call<String>

    //suspend fun sendPhoneNumber(phoneNumber: String): Call<SendPhoneNumberRequestModel>

    @POST("/mobile_verification")
    suspend fun sendPhoneNumberNew(@Body req: SendPhoneNumberRequestModel): Response<SendPhoneNumberResponseModel>

    @GET("/dashboard_information")
    suspend fun requestDashboardInformation(): Response<SendDashboardResponseModel>
}