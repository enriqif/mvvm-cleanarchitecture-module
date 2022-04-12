package com.enriqif.globallogicapp.view
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.enriqif.domain.model.Notebook
import com.enriqif.globallogicapp.R
import com.enriqif.globallogicapp.common.Constants.NOTEBOOK_DETAIL_TITLE
import com.enriqif.globallogicapp.common.Constants.NOTEBOOK_KEY
import com.enriqif.globallogicapp.databinding.ActivityNotebookDetailBinding


class NotebookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotebookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotebookDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent?.let {
            val notebook = intent.extras!!.getParcelable< Notebook>(NOTEBOOK_KEY)!!
            binding.detail.text = notebook.description
            binding.title.text = notebook.title

            Glide
                .with(this)
                .load(notebook.image)
                .centerCrop()
                .placeholder(R.drawable.icon_notebook)
                .into(binding.imageHeader)
        }

        // toolbar
        supportActionBar?.title = NOTEBOOK_DETAIL_TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}