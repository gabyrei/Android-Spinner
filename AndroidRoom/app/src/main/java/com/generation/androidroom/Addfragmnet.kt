package com.generation.androidroom

import android.accessibilityservice.FingerprintGestureController
import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.generation.androidroom.databinding.FragmentAddfragmnetBinding
import com.generation.androidroom.placeholder.PlaceholderContent


class Addfragmnet : Fragment() {

    private lateinit var binding: FragmentAddfragmnetBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Iflatre the layout for this fragment
          binding =  FragmentAddfragmnetBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonAdd.setOnClickListener {
            inserirNoBanco()
        }
        return binding.root
    }

    fun verificarCampos(nome: String, sobrenome: String, idade: String ): Boolean{
        return !(nome == "" || sobrenome == "" || idade == "")

    }

    fun inserirNoBanco() {

        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()

        if (verificarCampos(nome, sobrenome, idade)) {
            val user = Usuario(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuario Adicionado!", Toast.LENGTH_LONG).show()
            findNovController().navigate(. R . id . action_addFragment_to_listfragment)
        }else{
            Toast.makeText(context,"Preencha todos os Campo ", Toast.LENGTH_LONG).show()


        }
    }
}