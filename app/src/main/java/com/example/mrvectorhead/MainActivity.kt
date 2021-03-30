package com.example.mrvectorhead

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var hair : ImageView
    private lateinit var eyebrow : ImageView
    private lateinit var eyes : ImageView
    private lateinit var moustache : ImageView
    private lateinit var beard : ImageView
    private lateinit var body : ImageView
    private lateinit var CHead : Button
    private lateinit var CHair : Button
    private lateinit var CEyebrow : Button
    private lateinit var CEyes : Button
    private lateinit var CMoustache : Button
    private lateinit var CBeard : Button
    private var SELECT_IMAGE_CODE = 1
    private lateinit var option : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hair = findViewById(R.id.hair)
        eyebrow = findViewById(R.id.eyebrow)
        eyes = findViewById(R.id.eye)
        moustache = findViewById(R.id.moustache)
        beard = findViewById(R.id.beard)
        body = findViewById(R.id.body)
        CHead = findViewById(R.id.CHead)
        CHair = findViewById(R.id.CHair)
        CEyebrow = findViewById(R.id.CEyebrow)
        CEyes = findViewById(R.id.CEyes)
        CMoustache = findViewById(R.id.CMoustache)
        CBeard = findViewById(R.id.CBeard)

        CHair.setOnClickListener {
            option = hair
            move()
        }

        CHead.setOnClickListener {
            option = body
            move()
        }

        CEyebrow.setOnClickListener {
            option = eyebrow
            move()
        }

        CEyes.setOnClickListener {
            option = eyes
            move()
        }

        CMoustache.setOnClickListener {
            option = moustache
            move()
        }

        CBeard.setOnClickListener {
            option = beard
            move()
        }

    }

//    fun View.toggleVisibility(){
//
//        if (visibility == View.VISIBLE){
//            visibility = View.INVISIBLE
//        } else{
//            visibility = View.VISIBLE
//        }
//    }

    fun move() {
        var intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            var uri : Uri? = data?.data
            option.setImageURI(uri)
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putBoolean("CHead",CHead.isChecked)
//        outState.putBoolean("CHair",CHair.isChecked)
//        outState.putBoolean("CMoustache",CMoustache.isChecked)
//        outState.putBoolean("CEyes",CEyes.isChecked)
//        outState.putBoolean("CEyebrow",CEyebrow.isChecked)
//        outState.putBoolean("CBeard",CBeard.isChecked)
//        outState.putInt("Head",body.visibility)
//        outState.putInt("Hair",hair.visibility)
//        outState.putInt("Moustache",moustache.visibility)
//        outState.putInt("Eyes",eyes.visibility)
//        outState.putInt("Eyebrow",eyebrow.visibility)
//        outState.putInt("Beard",beard.visibility)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        CHead.setChecked(savedInstanceState.getBoolean("CHead"))
//        CHair.setChecked(savedInstanceState.getBoolean("CHair"))
//        CMoustache.setChecked(savedInstanceState.getBoolean("CMoustache"))
//        CEyes.setChecked(savedInstanceState.getBoolean("CEyes"))
//        CEyebrow.setChecked(savedInstanceState.getBoolean("CEyebrow"))
//        CBeard.setChecked(savedInstanceState.getBoolean("CBeard"))
//        body.setVisibility(savedInstanceState.getInt("Head"))
//        hair.setVisibility(savedInstanceState.getInt("Hair"))
//        moustache.setVisibility(savedInstanceState.getInt("Moustache"))
//        eyes.setVisibility(savedInstanceState.getInt("Eyes"))
//        eyebrow.setVisibility(savedInstanceState.getInt("Eyebrow"))
//        beard.setVisibility(savedInstanceState.getInt("Beard"))
//    }

}