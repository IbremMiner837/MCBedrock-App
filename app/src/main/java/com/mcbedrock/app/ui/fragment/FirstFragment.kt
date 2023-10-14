package com.mcbedrock.app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.mcbedrock.app.R
import com.mcbedrock.app.adapter.NewsAdapter
import com.mcbedrock.app.databinding.FragmentFirstBinding
import com.mcbedrock.app.viewmodel.NewsViewModel

class FirstFragment : Fragment() {
    var viewModel: NewsViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: NewsAdapter? = null
    var layoutManager: LayoutManager? = null

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = _binding?.recyclerview
        layoutManager = LinearLayoutManager(requireActivity())
        recyclerView!!.layoutManager = layoutManager

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel!!.getNewsList.observe(viewLifecycleOwner) { newsEntry ->
            if (newsEntry != null) {
                Log.e("NewsFragment", "NewsList: " + newsEntry.get(0).entries.get(0).title)

                if (newsEntry != null) {
                    adapter = NewsAdapter(requireActivity(), newsEntry)
                    adapter!!.notifyDataSetChanged()
                    recyclerView!!. adapter = adapter
                }
            }
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}