package com.iamshekhargh.mypizzaapp.models.response

import com.iamshekhargh.mypizzaapp.models.DashboardItemUrlName
import com.iamshekhargh.mypizzaapp.models.Order

data class SendDashboardResponseModel(
    val promotionImages: List<String>,
    val mainMenuList: List<DashboardItemUrlName>,
    val offersList: List<DashboardItemUrlName>,
    val bestsellerList: List<DashboardItemUrlName>,
    val laseOrder: Order
)
