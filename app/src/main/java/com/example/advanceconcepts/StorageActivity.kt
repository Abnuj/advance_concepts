package com.example.advanceconcepts

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.createBitmap
import androidx.core.graphics.drawable.toBitmap
import com.example.advanceconcepts.databinding.ActivityStorageBinding

class StorageActivity : AppCompatActivity() {
    lateinit var binding: ActivityStorageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.storageBtn.setOnClickListener {
            saveDataToInternalStorage()
        }

    }

    private fun saveDataToInternalStorage() {
        saveTextFile()
    }

    private fun saveTextFile() {
//        val i: File = File(filesDir,"app1.txt")
        try {
            val j: Bitmap = getDrawable(R.drawable.ic_launcher_background)!!.toBitmap()
            val i = openFileOutput("app2.jpg", Context.MODE_PRIVATE)
            j.compress(Bitmap.CompressFormat.JPEG, 100, i)
            i.flush()
        } catch (e: Exception) {
            Log.d("TAGG", "exception is :${e.message}")
        }
//        i.writeText("this is demo text which is writetent by greate abnuj bhai ohhyes",Charsets.UTF_8)

    }
}