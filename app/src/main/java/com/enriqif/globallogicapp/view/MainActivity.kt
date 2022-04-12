package com.enriqif.globallogicapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.enriqif.domain.model.Notebook
import com.enriqif.globallogicapp.R
import com.enriqif.globallogicapp.adapter.NotebookRecyclerAdapter
import com.enriqif.globallogicapp.common.Constants.NOTEBOOK_KEY
import com.enriqif.globallogicapp.databinding.ActivityMainBinding
import com.enriqif.globallogicapp.viewmodel.NotebookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotebookRecyclerAdapter.NotebookClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notebookAdapter: NotebookRecyclerAdapter
    private lateinit var viewModel: NotebookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[NotebookViewModel::class.java]
        viewModel.state.observe(this){ listState ->
            if (!listState.isLoading){
                binding.progressBar.visibility = View.INVISIBLE
                if (listState.error.isNotBlank()){
                    binding.errorText.text = listState.error
                    binding.errorText.visibility = View.VISIBLE
                }
                else{
                    binding.recyclerView.visibility = View.VISIBLE
                    notebookAdapter = NotebookRecyclerAdapter(this, listState.notebooks, this)
                    binding.recyclerView.adapter = notebookAdapter
                }
            }
        }
    }

    override fun onItemClick(notebook: Notebook) {
        val intent = Intent(this, NotebookDetailActivity::class.java)
        intent.putExtra(NOTEBOOK_KEY, notebook)
        startActivity(intent)
    }
}