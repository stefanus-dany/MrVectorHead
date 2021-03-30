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
    private var SELECT_IMAGE_CODE = 1
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

    fun move() {
        var intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && option == body) {
            var uri = data?.data
            svBody = uri
            option.setImageURI(uri)
        } else if (requestCode == 1 && option == hair) {
            var uri = data?.data
            svHair = uri
            option.setImageURI(uri)
        } else if (requestCode == 1 && option == eyebrow) {
            var uri = data?.data
            svEyebrow = uri
            option.setImageURI(uri)
        }else if (requestCode == 1 && option == eyes) {
            var uri = data?.data
            svEye = uri
            option.setImageURI(uri)
        }else if (requestCode == 1 && option == moustache) {
            var uri = data?.data
            svMoutache = uri
            option.setImageURI(uri)
        }else if (requestCode == 1 && option == beard) {
            var uri = data?.data
            svBeard = uri
            option.setImageURI(uri)
    }}


//        if (savedInstanceState != null) {
//            var image = savedInstanceState.getParcelableExtra("BitmapImage") as Bitmap
//            var images = savedInstanceState.getParce
//        } else {
//            image = yourBitmapImage
//        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("bodyImage", svBody)
        outState.putParcelable("hairImage", svHair)
        outState.putParcelable("eyebrowImage", svEyebrow)
        outState.putParcelable("eyes", svEye)
        outState.putParcelable("moustache", svMoutache)
        outState.putParcelable("beard", svBeard)
    }


//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        body.setImageURI(savedInstanceState.getParcelable("bodyImage"))
//        hair.setImageURI(savedInstanceState.getParcelable("hairImage"))
//        eyebrow.setImageURI(savedInstanceState.getParcelable("eyebrowImage"))
//        eyes.setImageURI(savedInstanceState.getParcelable("eyes"))
//        moustache.setImageURI(savedInstanceState.getParcelable("moustache"))
//        beard.setImageURI(savedInstanceState.getParcelable("beard"))
//    }
}

