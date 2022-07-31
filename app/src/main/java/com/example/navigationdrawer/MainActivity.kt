package com.example.navigationdrawer

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.navigationdrawer.fragments.FriendsFragment
import com.example.navigationdrawer.fragments.MessageFragment
import com.example.navigationdrawer.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val profileFragment = ProfileFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, profileFragment)
            .addToBackStack("profile").commit()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.app_name, R.string.app_name)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, profileFragment).addToBackStack("profile").commit()
                }
                R.id.messages -> {
                    val messageFragment = MessageFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, messageFragment).addToBackStack("message").commit()
                }
                R.id.friends -> {
                    val friendsFragment = FriendsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, friendsFragment).addToBackStack("friends").commit()

                }
                R.id.update -> Toast.makeText(
                    this, "Your profile has been updated",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.sing_out -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setMessage("Are you sure you want to live this page")

                    builder.setPositiveButton("Ok") { _, _ ->
                        finish()
                    }

                    builder.setNegativeButton("Cancel") { dialog, _ ->
                        dialog?.cancel()
                    }
                    builder.show()
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}