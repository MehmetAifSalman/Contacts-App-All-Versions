package com.example.kisileruygulamas.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamas.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class KisiKayitViewModel @Inject constructor(var KRepo : KisilerRepository) : ViewModel(){

    fun Buttonkaydet(Kisi_ad : String , Kisi_tel : String){
         CoroutineScope(Dispatchers.Main).launch {
             KRepo.Buttonkaydet(Kisi_ad , Kisi_tel)
         }



    }
}