package com.example.kisileruygulamas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.databinding.CardTasarimBinding
import com.example.kisileruygulamas.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamas.ui.viewModel.AnasayfaViewModel
import com.example.kisileruygulamas.util.gecisyap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context , var KisiListesi : List<Kisiler> , var viewModel : AnasayfaViewModel) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarımTutucu>()
{
    inner  class CardTasarımTutucu(var tasarım : CardTasarimBinding) : RecyclerView.ViewHolder(tasarım.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarımTutucu {

        var binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext) ,R.layout.card_tasarim, parent , false)
        return CardTasarımTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarımTutucu, position: Int) {
        val kisi = KisiListesi.get(position)
        val t = holder.tasarım
        t.kisiNesnesi = kisi
        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisyap(it , gecis)
        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it , "${kisi.kisi_ad} Silinsin mi?" , Snackbar.LENGTH_SHORT).setAction("Evet")
            {
                viewModel.Buttonsil(kisi.kisi_id)
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return KisiListesi.size
    }
}