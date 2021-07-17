package com.mutsanna.githubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

private lateinit var adapter: UserAdapter
private lateinit var dataName: Array<String>
private lateinit var dataUser: Array<String>
private lateinit var dataFollowers: Array<String>
private lateinit var dataFollowing: Array<String>
private lateinit var dataLocation: Array<String>
private lateinit var dataCompany: Array<String>
private lateinit var dataRepo: Array<String>
private lateinit var dataPhoto: TypedArray
private var users = arrayListOf<User>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            //Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
            val intenuser = User(
                    users[position].photo,
                    users[position].name,
                    users[position].username,
                    users[position].followers,
                    users[position].following,
                    users[position].location,
                    users[position].company,
                    users[position].repo
            )
            val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_USER, intenuser)
            startActivity(moveWithObjectIntent)
        }
    }

    private fun prepare() {
        dataUser = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.data_name)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataLocation = resources.getStringArray(R.array.location)
        dataCompany = resources.getStringArray(R.array.company)
        dataRepo = resources.getStringArray(R.array.repo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                    dataPhoto.getResourceId(position, -1),
                    dataName[position],
                    dataUser[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataLocation[position],
                    dataCompany[position],
                    dataRepo[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}