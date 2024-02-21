package com.example.kisileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamas.ui.viewModel.KisiKayitViewModel
import com.example.kisileruygulamas.ui.viewModel.KisideatyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewmodel : KisiKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)
        binding.kisiKayitToolBarBaslik = "Kişi Kayıt"
        binding.kisiKayitFragment = this
        return binding.root



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : KisiKayitViewModel by viewModels()
        viewmodel = temp
    }

    fun Buttonkaydet(Kisi_ad : String , Kisi_tel : String){

        viewmodel.Buttonkaydet(Kisi_ad , Kisi_tel)
    }

}