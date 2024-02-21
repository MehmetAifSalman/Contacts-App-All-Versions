package com.example.kisileruygulamas.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var KRepo : KisilerRepository) : ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    init {
        kisileriYukle()
    }
    fun Buttonsil(kisi_id : Int)
    {
        CoroutineScope(Dispatchers.Main).launch{
            KRepo.Buttonsil(kisi_id)
            kisileriYukle()
        }

    }
     fun kisileriYukle()
     {
         CoroutineScope(Dispatchers.Main).launch {

             kisilerListesi.value =  KRepo.kisileriYukle()
         }
     }
    fun arama(aranan : String)
    {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = KRepo.arama(aranan)
        }
    }
}