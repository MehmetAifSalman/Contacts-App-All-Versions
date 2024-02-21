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
class KisideatyViewModel @Inject constructor(var KRepo : KisilerRepository) : ViewModel() {

    fun Buttonguncelle(kisi_id : Int , kisi_ad : String , kisi_tel : String)
    {
        CoroutineScope(Dispatchers.Main).launch {
            KRepo.Buttonguncelle(kisi_id , kisi_ad , kisi_tel)
            Log.e("kisi id" , "kidi id : $kisi_id")
        }
    }
}