package com.mcbedrock.app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcbedrock.app.NewsItemsAdapter
import com.mcbedrock.app.R
import com.mcbedrock.app.apiservice.ApiService
import com.mcbedrock.app.databinding.FragmentFirstBinding
import com.mcbedrock.app.repository.NewsRepository
import com.mcbedrock.app.viewmodel.NewsViewModel
import com.mcbedrock.app.viewmodel.NewsViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsItemsAdapter

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = Retrofit.Builder()
            .baseUrl("https://launchercontent.mojang.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = NewsRepository(apiService)
        val viewModelFactory = NewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        viewModel.items.observe(this, Observer {
            adapter.submitList(it)  // Use submitList instead of recreating the adapter
        })

        viewModel.fetchItems()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = NewsItemsAdapter(emptyList())
        recyclerView.adapter = adapter

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}