package com.polarmods.architecturechecker

import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val isAutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.AutoComplete)
        val isArrayAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, ListSomePackages())

        isAutoCompleteTextView.setAdapter(isArrayAdapter)

        isAutoCompleteTextView.onItemClickListener = OnItemClickListener { parent, view, position, id ->

            val isSelectedItem : String = parent.getItemAtPosition(position).toString()
            val isPackageName: String = isSelectedItem
            val isPackageLibraryDir : String = packageManager.getApplicationInfo(isPackageName, 0).nativeLibraryDir

            var isArchitectureFound = false

            if(isPackageLibraryDir.endsWith("arm64", false))
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = arm64", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
                isArchitectureFound = true
            }

            if(isPackageLibraryDir.endsWith("arm", false))
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = arm", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
                isArchitectureFound = true
            }

            if(isPackageLibraryDir.endsWith("x86", false))
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = x86", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
                isArchitectureFound = true
            }

            if(isPackageLibraryDir.endsWith("x86_64", false))
            {
                Snackbar.make(findViewById(android.R.id.content), "$isPackageName = x86_64", Snackbar.LENGTH_LONG).setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE).setBackgroundTint(Color.parseColor("#343840")).setTextColor(Color.parseColor("#FFFFFF")).show()
                isArchitectureFound = true
            }

            if(!isArchitectureFound)
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