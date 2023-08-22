package com.desafiolatam.surveydonkey.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.desafiolatam.surveydonkey.databinding.ActivityMainBinding
import com.desafiolatam.surveydonkey.ui.adapter.SurveyPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewPager: SurveyPagerAdapter

    private val STORAGE_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = SurveyPagerAdapter(this)
        binding.vpMain.adapter = viewPager



        binding.fab.setOnClickListener {
            when (binding.vpMain.currentItem) {
                0 -> binding.vpMain.setCurrentItem(1, true)
                1 -> binding.vpMain.setCurrentItem(2, true)
                2 -> binding.vpMain.setCurrentItem(3, true)
                3 -> binding.vpMain.setCurrentItem(4, true)
                4 ->{
                    binding.vpMain.setCurrentItem(5, true)
                    requestStoragePermission()}
                5 ->{
                    binding.vpMain.setCurrentItem(6, true)
                    requestStoragePermission()
                }
            }
        }


    }

    private fun requestStoragePermission() {
        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), STORAGE_PERMISSION_REQUEST_CODE)
        } else {
            // Permiso ya concedido, puedes realizar acciones que requieren acceso al almacenamiento aquí
            Log.i("requestStoragePermission", ContextCompat.checkSelfPermission(this, permission).toString())
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, puedes realizar acciones que requieren acceso al almacenamiento aquí
                Log.i("onRequestPermissionsResultIF", requestCode.toString())
            } else {
                // Permiso denegado, puedes mostrar un mensaje o tomar medidas apropiadas
                Log.i("onRequestPermissionsResultELSE", requestCode.toString())
            }
        }
    }
}