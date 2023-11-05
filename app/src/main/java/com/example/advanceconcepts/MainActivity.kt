package com.example.advanceconcepts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.core.content.edit
import com.example.advanceconcepts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var auntyJokesString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.readSp.text = "Read shared Preferences"
        binding.writeSp.text = "Write shared Preferences"
        getAuntyJokesinList()
        sharePreferenceComplete()

    }

    fun String.addString(s1: String): String {
        return this + s1 + "\n===\t===\n"
    }

    private fun getAuntyJokesinList() {
        val auntyjokes: Array<String> = resources.getStringArray(R.array.jokes)
        auntyjokes.forEach {
            auntyJokesString = auntyJokesString.addString(it)
            Log.d("TAGG", "curretn value: ${it}")
            Log.d("TAGG", "getAuntyJokesinList: ${auntyJokesString}")
        }
    }

    private fun sharePreferenceComplete() {
        binding.writeSp.setOnClickListener {
//            writeSharePreference()
            goToStorageActivity()
        }
        binding.readSp.setOnClickListener {
            readSharedPref()
        }
    }

    private fun goToStorageActivity() {
        startActivity(Intent(this, StorageActivity::class.java))
    }

    private fun readSharedPref() {
        val sp1 = getSharedPreferences(Keys.SHARE_PREF_1.toString(), Context.MODE_PRIVATE) ?: return
        val i: String? = sp1.getString("auntyJokes", "THIS IS DEFAULT VALUE")
        i?.let { binding.readtv.text = i }
    }

    private fun writeSharePreference() {
        val shareRf: SharedPreferences =
            getSharedPreferences(Keys.SHARE_PREF_1.toString(), Context.MODE_PRIVATE) ?: return
//        val share2 = this.getSharedPreferences("KEY2", Context.MODE_PRIVATE) ?: return

        with(shareRf.edit()) {
            putString("auntyJokes", auntyJokesString)
            putInt("age", 2)
            apply()
        }
//        share2.edit {
//            putString("name", "this is key 3 ")
//            putInt("age", 4)
//            apply()
//        }
    }
}

enum class Keys {
    SHARE_PREF_1
}


