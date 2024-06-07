package com.example.catastrophiccafe

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.cardview.widget.CardView

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val welcome: TextView = findViewById(R.id.welcome)
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        "Welcome, $username".also { welcome.text = it }

        val scrollView = ScrollView(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        scrollView.layoutParams = layoutParams

        val linearLayout = LinearLayout(this)
        val linearParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = linearParams

        scrollView.addView(linearLayout)

        val image1 = ImageView(this)
        val params1 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        //setting margin
        params1.setMargins(0, 30, 0, 30)
        //aligning the layout to center of the screen
        params1.gravity = Gravity.CENTER
        image1.setLayoutParams(params1)
        //setting our own downloaded/custom image to the imageView
        image1.setImageResource(R.drawable.image1)
        linearLayout.addView(image1)

        val image2 = ImageView(this)
        val params2 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params2.setMargins(0, 0, 0, 30)
        params2.gravity = Gravity.CENTER
        image2.setLayoutParams(params2)
        image2.setImageResource(R.drawable.image2)
        linearLayout.addView(image2)

        val image3 = ImageView(this)
        val params3 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params3.setMargins(0, 0, 0, 30)
        params3.gravity = Gravity.CENTER
        image3.setLayoutParams(params3)
        image3.setImageResource(R.drawable.image3)
        linearLayout.addView(image3)

        val image4 = ImageView(this)
        val params4 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params4.setMargins(0, 0, 0, 30)
        params4.gravity = Gravity.CENTER
        image4.setLayoutParams(params4)
        image4.setImageResource(R.drawable.image4)
        linearLayout.addView(image4)

        val image5 = ImageView(this)
        val params5 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params5.setMargins(0, 0, 0, 30)
        params5.gravity = Gravity.CENTER
        image5.setLayoutParams(params5)
        image5.setImageResource(R.drawable.image5)
        linearLayout.addView(image5)

        val image6 = ImageView(this)
        val params6 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params6.setMargins(0, 0, 0, 30)
        params6.gravity = Gravity.CENTER
        image6.setLayoutParams(params6)
        image6.setImageResource(R.drawable.image6)
        linearLayout.addView(image6)

        val image7 = ImageView(this)
        val params7 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params7.setMargins(0, 0, 0, 30)
        params7.gravity = Gravity.CENTER
        image7.setLayoutParams(params6)
        image7.setImageResource(R.drawable.image7)
        linearLayout.addView(image7)

        val image8 = ImageView(this)
        val params8 =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params8.setMargins(0, 0, 0, 30)
        params8.gravity = Gravity.CENTER
        image8.setLayoutParams(params6)
        image8.setImageResource(R.drawable.image8)
        linearLayout.addView(image8)


//        val linearLayout1 = findViewById<LinearLayout>(R.id.layout)
//        linearLayout1?.addView(scrollView)

        //navigations for the header


            val about_us = findViewById<Button>(R.id.aboutUsbtn)

            about_us.setOnClickListener() {
                val intent = Intent(this, aboutUs::class.java)
                intent.putExtra("username", username)
                intent.putExtra("email", email)
                startActivity(intent)
            }

            val profile = findViewById<Button>(R.id.profileBtn)

            profile.setOnClickListener() {
                val intent = Intent(this, profilePage::class.java)
                intent.putExtra("username", username)
                intent.putExtra("email", email)
                startActivity(intent)
            }

        //card view product navigations

        val cafeLatte = findViewById<CardView>(R.id.cafeLatte)

        cafeLatte.setOnClickListener() {
            val intent = Intent(this, cafe_latte::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
            }

        val cafeMocha = findViewById<CardView>(R.id.cafeMocha)

        cafeMocha.setOnClickListener() {
            val intent = Intent(this, cafe_mocha::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val flatWhite = findViewById<CardView>(R.id.flatWhite)

        flatWhite.setOnClickListener() {
            val intent = Intent(this, flat_white::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val espresso = findViewById<CardView>(R.id.espresso)

        espresso.setOnClickListener() {
            val intent = Intent(this, espresso::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val meowMixAndTender = findViewById<CardView>(R.id.meowMix)

        meowMixAndTender.setOnClickListener() {
            val intent = Intent(this, meow_mix_tender::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val meOMackerel = findViewById<CardView>(R.id.MEOMackerel)

        meOMackerel.setOnClickListener() {
            val intent = Intent(this, ME_O_Mackerel::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val whiskasTuna = findViewById<CardView>(R.id.whiskasTuna)

        whiskasTuna.setOnClickListener() {
            val intent = Intent(this, Whiskas_Tuna::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val rachelRayNutrish = findViewById<CardView>(R.id.nutrish)

        rachelRayNutrish.setOnClickListener() {
            val intent = Intent(this, Rachel_Ray_Nutrish::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            startActivity(intent)
        }

    }
}
