package com.example.kisileruygulamas.data.repo

import com.example.kisileruygulamas.data.datasource.KisilerDataSource
import com.example.kisileruygulamas.data.entity.Kisiler

class KisilerRepository(var kds : KisilerDataSource) {
    suspend fun Buttonkaydet(Kisi_ad : String , Kisi_tel : String) = kds.Buttonkaydet(Kisi_ad, Kisi_tel)
    suspend fun Buttonguncelle(kisi_id : Int , kisi_ad : String , kisi_tel : String) = kds.Buttonguncelle(kisi_id , kisi_ad , kisi_tel)
    suspend fun Buttonsil(kisi_id : Int) = kds.Buttonsil(kisi_id)
    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()
    suspend fun arama(aramaKelimesi : String)  : List<Kisiler>  = kds.arama(aramaKelimesi)
}