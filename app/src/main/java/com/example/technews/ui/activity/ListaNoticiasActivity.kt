package com.example.technews.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.technews.R
import com.example.technews.model.Noticia
import com.example.technews.ui.recyclerview.adapter.ListaNoticiasAdapter
import kotlinx.android.synthetic.main.activity_lista_noticias.*

private const val TITULO_APPBAR = "Notícias"

class ListaNoticiasActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListaNoticiasAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_noticias)
        title = TITULO_APPBAR
        configurarRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        buscaNoticias()
    }

    private fun configurarRecyclerView() {
        val divisor = DividerItemDecoration(this, VERTICAL)
        activity_lista_noticias_recyclerview.addItemDecoration(divisor)
        activity_lista_noticias_recyclerview.adapter = adapter
        configurarAdapter()
    }

    private fun configurarAdapter() {

    }

    private fun buscaNoticias() {
        var noticias: MutableList<Noticia> = mutableListOf()

        noticias.add(0, Noticia(id = 0, titulo = "Título 1", texto = "Texto 1"))
        noticias.add(0, Noticia(id = 0, titulo = "Título 2", texto = "Texto 2"))
        adapter.atualiza(noticias)
    }
}
