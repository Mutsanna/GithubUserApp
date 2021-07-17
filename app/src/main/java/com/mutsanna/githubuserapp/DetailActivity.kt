package com.mutsanna.githubuserapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: CircleImageView = findViewById(R.id.img_photo)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvFollowers : TextView = findViewById(R.id.tv_followers)
        val tvFollowing : TextView = findViewById(R.id.tv_following)
        val tvLocation : TextView = findViewById(R.id.tv_location)
        val tvCompany : TextView = findViewById(R.id.tv_company)
        val btnRepo : Button = findViewById(R.id.button)
        btnRepo.setOnClickListener(this)


        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User


        val textNama = "Name : ${user.name.toString()}"
        val textDetail = "Username Github : ${user.username.toString()}"
        val textFollowers = "Followers : ${user.followers.toString()}"
        val textFollowing = "Following : ${user.following.toString()}"
        val textLocation = "Lokasi : ${user.location.toString()}"
        val textCompany = "Perusahaan : ${user.company.toString()}"

        imgPhoto.setImageResource(user.photo)
        tvName.text = textNama
        tvUsername.text = textDetail
        tvFollowers.text = textFollowers
        tvFollowing.text = textFollowing
        tvLocation.text = textLocation
        tvCompany.text = textCompany
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> {
                val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
                val phoneNumber = user.repo
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(phoneNumber))
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }


}