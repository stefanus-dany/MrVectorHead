package com.example.mrvectorhead

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var hair: ImageView
    private lateinit var eyebrow: ImageView
    private lateinit var eyes: ImageView
    private lateinit var moustache: ImageView
    private lateinit var beard: ImageView
    private lateinit var body: ImageView
    private lateinit var CHead: Button
    private lateinit var CHair: Button
    private lateinit var CEyebrow: Button
    private lateinit var CEyes: Button
    private lateinit var CMoustache: Button
    private lateinit var CBeard: Button
    private lateinit var option: ImageView
    var svBody: Uri? = null
    var svHair: Uri? = null
    var svEyebrow: Uri? = null
    var svEye: Uri? = null
    var svMoutache: Uri? = null
    var svBeard: Uri? = null

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

        if (savedInstanceState != null) {
            body.setImageURI(savedInstanceState.getParcelable("bodyImage"))
            hair.setImageURI(savedInstanceState.getParcelable("hairImage"))
            eyebrow.setImageURI(savedInstanceState.getParcelable("eyebrowImage"))
            eyes.setImageURI(savedInstanceState.getParcelable("eyes"))
            moustache.setImageURI(savedInstanceState.getParcelable("moustache"))
            beard.setImageURI(savedInstanceState.getParcelable("beard"))

            svBody = savedInstanceState.getParcelable("bodyImage")
            svHair = savedInstanceState.getParcelable("hairImage")
            svEyebrow = savedInstanceState.getParcelable("eyebrowImage")
            svEye = savedInstanceState.getParcelable("eyes")
            svMoutache = savedInstanceState.getParcelable("moustache")
            svBeard = savedInstanceState.getParcelable("beard")
        }

        CHead.setOnClickListener {
            option = body
            move(1)
        }

        CHair.setOnClickListener {
            option = hair
            move(2)
        }

        CEyebrow.setOnClickListener {
            option = eyebrow
            move(3)
        }

        CEyes.setOnClickListener {

            option = eyes
            move(4)
        }

        CMoustache.setOnClickListener {

            option = moustache
            move(5)
        }

        CBeard.setOnClickListener {

            option = beard
            move(6)
        }

    }

    fun move(angka : Int) {
        var intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Title"), angka)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            var uri = data?.data
            svBody = uri
            body.setImageURI(uri)
        } else if (requestCode == 2) {
            var uri = data?.data
            svHair = uri
            hair.setImageURI(uri)
        } else if (requestCode == 3) {
            var uri = data?.data
            svEyebrow = uri
            eyebrow.setImageURI(uri)
        }else if (requestCode == 4) {
            var uri = data?.data
            svEye = uri
            eyes.setImageURI(uri)
        }else if (requestCode == 5) {
            var uri = data?.data
            svMoutache = uri
            moustache.setImageURI(uri)
        }else if (requestCode == 6) {
            var uri = data?.data
            svBeard = uri
            beard.setImageURI(uri)
    }}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("bodyImage", svBody)
        outState.putParcelable("hairImage", svHair)
        outState.putParcelable("eyebrowImage", svEyebrow)
        outState.putParcelable("eyes", svEye)
        outState.putParcelable("moustache", svMoutache)
        outState.putParcelable("beard", svBeard)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        body.setImageURI(savedInstanceState.getParcelable("bodyImage"))
        hair.setImageURI(savedInstanceState.getParcelable("hairImage"))
        eyebrow.setImageURI(savedInstanceState.getParcelable("eyebrowImage"))
        eyes.setImageURI(savedInstanceState.getParcelable("eyes"))
        moustache.setImageURI(savedInstanceState.getParcelable("moustache"))
        beard.setImageURI(savedInstanceState.getParcelable("beard"))
    }
}

