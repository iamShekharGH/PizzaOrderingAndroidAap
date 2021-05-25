package com.iamshekhargh.mypizzaapp.models

data class Order(
    val orderNum: Int,
    val items: Int,
    val itemsList: List<String>,
    val orderPlacedDate: String,
    val orderAmount: Int
)
