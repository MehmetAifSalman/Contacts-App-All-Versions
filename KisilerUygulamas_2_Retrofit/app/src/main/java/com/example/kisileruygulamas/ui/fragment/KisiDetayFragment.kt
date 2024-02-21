package com.example.kisileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamas.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamas.ui.viewModel.KisiKayitViewModel
import com.example.kisileruygulamas.ui.viewModel.KisideatyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewmodel : KisideatyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        binding.kisidetayFragment = this
        binding.toolBarKisiDetayBaslik = "Kisi Detay"
        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelen_kisi = bundle.kisi
        binding.kisi = gelen_kisi

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : KisideatyViewModel by viewModels()
        viewmodel = temp

    }

    fun Kisiguncelle(kisi_id : Int , kisi_ad : String , kisi_tel : String)
    {
        viewmodel.Buttonguncelle(kisi_id , kisi_ad , kisi_tel)
    }

}