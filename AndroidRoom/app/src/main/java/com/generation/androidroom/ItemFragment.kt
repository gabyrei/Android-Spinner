package com.generation.androidroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import com.generation.androidroom.adapter.UserAdapter
import com.generation.androidroom.databinding.FragmentItemBinding
import com.generation.androidroom.placeholder.PlaceholderContent

/
class ItemFragment : Fragment() {

    private  lateinit var binding: FragmentItemBinding
   private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layaout for this fragmnet
       binding = FragmentItemBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter= UserAdapter()
        binding.recyclearUser.layoutManager = LinearLayoutManager(context)
        binding.recyclearUser.adapter = adapter
        binding.recyclearUser.setHasFixedSize(true)

        mainViewModel.selectUsers.observe(viewLifecycleOwner){
            response -> adapter.setList(response)
        }

        binding.floatingActionButton.setOnClickListnner{
            findNovCotroll().navigate(R.id.action_listFragmnet_to_addFragment)
        }


        return binding.root
    }


}