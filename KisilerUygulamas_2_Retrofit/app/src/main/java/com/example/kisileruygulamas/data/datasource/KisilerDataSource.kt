package com.example.kisileruygulamas.data.datasource

import android.util.Log
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.log

class KisilerDataSource(var kdao : KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO)
        {

            return@withContext kdao.KisileriYukle().kisiler
        }

   suspend fun Buttonkaydet(Kisi_ad : String , Kisi_tel : String) = kdao.kaydet(Kisi_ad , Kisi_tel)


   suspend fun Buttonguncelle(kisi_id : Int , kisi_ad : String , kisi_tel : String) = kdao.guncelle(kisi_id , kisi_ad , kisi_tel)
    suspend fun Buttonsil(kisi_id : Int) {
       val a =  kdao.sil(kisi_id)
        Log.e("kisi" , a.message.toString())
    }
    suspend fun arama(aramaKelimesi : String)  : List<Kisiler> =
    withContext(Dispatchers.IO)
    {


      return@withContext kdao.arama(aramaKelimesi).kisiler

    }
}