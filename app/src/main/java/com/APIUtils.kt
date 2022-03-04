package com

import com.API.APIClient
import com.API.APIConfiguration

class APIUtils {
    companion object {

        private val BASE_URL = "http://dev.equalinfotech.in/metaled/api/customers/"

        fun getServiceAPI(): APIConfiguration? {
            return APIClient.getApiClient(BASE_URL)!!.create(APIConfiguration::class.java)


        }

    }
}
