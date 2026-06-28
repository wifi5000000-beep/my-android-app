package com.example.browser

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val profiles = mutableListOf<Profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddProfile = findViewById<Button>(R.id.btnAddProfile)
        val profilesContainer = findViewById<LinearLayout>(R.id.profilesContainer)

        btnAddProfile.setOnClickListener {
            val newProfile = Profile("Profile ${profiles.size + 1}")
            profiles.add(newProfile)
            addProfileCard(profilesContainer, newProfile)
        }
    }

    private fun addProfileCard(container: LinearLayout, profile: Profile) {
        val card = layoutInflater.inflate(R.layout.profile_item, container, false)
        val tvName = card.findViewById<TextView>(R.id.tvProfileName)
        val btnLaunch = card.findViewById<Button>(R.id.btnLaunch)

        tvName.text = profile.name
        btnLaunch.setOnClickListener {
            val intent = Intent(this, BrowserActivity::class.java)
            startActivity(intent)
        }
        container.addView(card)
    }
}

data class Profile(val name: String)