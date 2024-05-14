package com.development.planet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var planetRecyclerView: RecyclerView
    private val list = arrayListOf<PlanetDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        planetRecyclerView = findViewById(R.id.rvPlanet)
        planetRecyclerView.setHasFixedSize(true)
        list.addAll(allOfDataPlanet())

        showRecyclerView()
    }

    // adapter + parcelize
    private fun showRecyclerView() {
        planetRecyclerView.layoutManager = LinearLayoutManager(this)
        val listPlanetDataAdapter = PlanetDataAdapter(list) {
            Intent(this, PlanetDetailActivity::class.java).apply {
                putExtra("planet", it)
                startActivity(this)
            }
        }
        planetRecyclerView.adapter = listPlanetDataAdapter
    }

    // create about icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return true
    }

    // action about icon
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                startActivity(Intent(this, AuthorActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // Get data from strings.xml
    @SuppressLint("Recycle")
    private fun allOfDataPlanet(): ArrayList<PlanetDataClass> {
        val planetName = resources.getStringArray(R.array.planetName)
        val planetType = resources.getStringArray(R.array.planetType)
        val planetDescription = resources.getStringArray(R.array.planetDescription)
        val planetPhoto = resources.obtainTypedArray(R.array.planetPhoto)
        val planetRadius = resources.getStringArray(R.array.planetRadius)
        val planetAverageTemperature = resources.getStringArray(R.array.planetAverageTemperature)
        val planetGravity = resources.getStringArray(R.array.planetGravity)

        val list = arrayListOf<PlanetDataClass>()
        for (i in planetName.indices) {
            val planetDataClass = PlanetDataClass(
                planetName[i],
                planetType[i],
                planetDescription[i],
                planetPhoto.getResourceId(i, -1),
                planetRadius[i],
                planetAverageTemperature[i],
                planetGravity[i]
            )
            list.add(planetDataClass)
        }
        return list
    }
}