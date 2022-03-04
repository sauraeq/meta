package com.API

class APIUtils {
    companion object {

        private val BASE_URL = "http://dev.equalinfotech.in/metaled/api/"

        fun getServiceAPI(): APIConfiguration? {
            return APIClient.getApiClient(BASE_URL)!!.create(APIConfiguration::class.java)


        }

    }
}
