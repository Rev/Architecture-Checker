package com.polarmods.architecturechecker

import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.io.File

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val isAutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.AutoComplete)
        val isArrayAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, ListSomePackages())

        isAutoCompleteTextView.setAdapter(isArrayAdapter)

        isAutoCompleteTextView.onItemClickListener = OnItemClickListener { parent, _, position, id ->

            val isSelectedItem : String = parent.getItemAtPosition(position).toString()
            val isPackageName: String = isSelectedItem
            val isPackageLibraryDir : String = packageManager.getApplicationInfo(isPackageName, 0).nativeLibraryDir

            val isArchRegex = ("arm64|arm|x86|x86_64").toRegex()
            val isArchNative = isArchRegex.find(isPackageLibraryDir)
            
            if (isArchNative != null)
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = ${isArchNative.value}", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
            }
            else
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = Undetermined", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
            }
        }
    }

    fun ListSomePackages(): MutableList<String>
    {
        val isInstalledPackages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val isPackageList : MutableList<String> = mutableListOf()

        for (i in isInstalledPackages)
        {
            isPackageList.add(i.packageName)
        }

        return isPackageList
    }

}