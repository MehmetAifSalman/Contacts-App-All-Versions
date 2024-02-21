package com.example.kisileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamas.ui.adapter.KisilerAdapter
import com.example.kisileruygulamas.ui.viewModel.AnasayfaViewModel
import com.example.kisileruygulamas.util.gecisyap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewmodel : AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragmenti = this
        binding.anasayfaToolBarBaslik = "Ana Sayfa"

        viewmodel.kisilerListesi.observe(viewLifecycleOwner)
        {
            val KisiListeAdapter = KisilerAdapter(requireContext() , it , viewmodel)
            binding.anasayfaAdapter = KisiListeAdapter
        }




        binding.searchview.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                viewmodel.arama(newText.toString())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewmodel.arama(query.toString())
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : AnasayfaViewModel by viewModels()
        viewmodel = temp
    }
    fun fabTikla(it:View)
    {
        Navigation.gecisyap(it , R.id.kisi_kayit_gecis)
    }

    override fun onResume() {
        super.onResume()
        viewmodel.kisileriYukle()
    }


}