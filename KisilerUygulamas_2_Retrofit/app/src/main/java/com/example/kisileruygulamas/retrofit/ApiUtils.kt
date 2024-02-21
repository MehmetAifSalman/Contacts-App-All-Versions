package com.example.kisileruygulamas.retrofit

class ApiUtils {
    companion object{
        val Base_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDao() : KisilerDao
        {
            return RetrofitClient.getclient(Base_URL).create(KisilerDao::class.java)
        }
    }
}