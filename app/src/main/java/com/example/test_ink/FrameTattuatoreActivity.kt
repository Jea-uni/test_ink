package com.example.test_ink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FrameTattuatoreActivity : AppCompatActivity() {

    private lateinit var recyclerViewStudi: RecyclerView
    private lateinit var dataStudi: ArrayList<DataClass>
    private lateinit var recyclerViewStili: RecyclerView
    private lateinit var dataStili: ArrayList<DataClass>
    lateinit var studiList: Array<String>
    lateinit var stiliList: Array<String>
    lateinit var instaView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_tattuatore)

        stiliList = resources.getStringArray(R.array.stili_nomi)
        studiList = resources.getStringArray(R.array.studi_nomi)

        recyclerViewStudi = findViewById(R.id.Studi_recyclerview)
        recyclerViewStudi.layoutManager = LinearLayoutManager(this)
        recyclerViewStudi.setHasFixedSize(true)

        recyclerViewStili = findViewById(R.id.Stili_recyclerview)
        recyclerViewStili.layoutManager = LinearLayoutManager(this)
        recyclerViewStili.setHasFixedSize(true)

        dataStudi = arrayListOf<DataClass>()
        dataStili = arrayListOf<DataClass>()

        getData()

        instaView = findViewById(R.id.tattoo_instagram_lbl)
        instaView.settings.javaScriptEnabled = true
        instaView.settings.domStorageEnabled = true
        instaView.loadUrl("https://www.instagram.com/ind.ego/")

    }

    private fun getData(){
        for (i in studiList.indices){
            val dataClassStudi = DataClass(studiList[i])
            //val dataClassStili = DataClass(stiliList[i])
            dataStudi.add(dataClassStudi)
        }
        recyclerViewStudi.adapter = AdapterClass(dataStudi)
        for(i in stiliList.indices){
            val dataClassStili = DataClass(stiliList[i])
            dataStili.add(dataClassStili)
        }
        recyclerViewStili.adapter = AdapterClass(dataStili)
    }
}