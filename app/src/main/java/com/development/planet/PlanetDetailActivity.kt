package com.development.planet

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlanetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.planet_detail_activity)
        // back icon
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // get of each id view
        val planetDataClass = intent.getParcelableExtra<PlanetDataClass>("planet")
        val planetPhotoDetail = findViewById<ImageView>(R.id.civPlanetDetail)
        val planetNameDetail = findViewById<TextView>(R.id.tvNamaPlanetDetail)
        val planetTypeDetail = findViewById<TextView>(R.id.tvPlanetTipeDetail)
        val planetRadiusDetail = findViewById<TextView>(R.id.tvRadiusDetail)
        val planetDescriptionDetail = findViewById<TextView>(R.id.tvDeskripsiDetail)
        val planetTemperatureDetail = findViewById<TextView>(R.id.tvSuhuDetail)
        val planetGravityDetail = findViewById<TextView>(R.id.tvGravitasiDetail)

        // set of each id view
        planetPhotoDetail.setImageResource(planetDataClass?.photo!!)
        planetNameDetail.text = planetDataClass.name
        planetTypeDetail.text = planetDataClass.type
        planetRadiusDetail.text = planetDataClass.radius
        planetDescriptionDetail.text = planetDataClass.description
        planetTemperatureDetail.text = planetDataClass.averageTemperature
        planetGravityDetail.text = planetDataClass.gravity
    }

    // action of share icon & back icon
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_share -> shareApp()
        }
        return super.onOptionsItemSelected(item)
    }

    // create share icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return true
    }

    private fun shareApp() {
        val appMsg =
            "Hey! check out this article about planet:\n" + "https://play.google.com/store/apps/details?id=com.development.planet"
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, appMsg)
        intent.type = "text/plain"
        startActivity(intent)
    }

}