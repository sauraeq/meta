package com.example.customnavigationdrawerexample


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2.ui.home.HomeFragment
import com.metaled.CartModule.CartActivity
import com.metaled.Customize_screen
import com.metaled.ProfileActivity
import com.metaled.R
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.activity_main1.img_prfil


class MainActivity1 : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    private lateinit var adapter: NavigationRVAdapter


    private var items = arrayListOf(
        NavigationItemModel(R.drawable.home, "Home"),
        NavigationItemModel(R.drawable.troly, "Cart"),
        NavigationItemModel(R.drawable.heart, "Wishlist"),
        NavigationItemModel(R.drawable.cube, "Products"),
        NavigationItemModel(R.drawable.group, "Categories"),
        NavigationItemModel(R.drawable.user, "Profile"),
       // NavigationItemModel(R.drawable.back, "Like us on facebook")
    )
    private var items1 = arrayListOf(
        NavigationItemModel(R.drawable.home_white, "Home"),
        NavigationItemModel(R.drawable.troly_white, "Cart"),
        NavigationItemModel(R.drawable.heart_white, "Wishlist"),
        NavigationItemModel(R.drawable.cube_white, "Products"),
        NavigationItemModel(R.drawable.group_white, "Categories"),
        NavigationItemModel(R.drawable.user_white, "Profile"),
        // NavigationItemModel(R.drawable.back, "Like us on facebook")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        drawerLayout = findViewById(R.id.drawer_layout)


        img_prfil.setOnClickListener() {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        ivClose.setOnClickListener() {
            drawerLayout.closeDrawer(GravityCompat.START)
                }
        // Set the toolbar
       // setSupportActionBar(activity_main_toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);

        // Setup Recyclerview's Layout
        navigation_rv.layoutManager = LinearLayoutManager(this)
        navigation_rv.setHasFixedSize(true)
        ivMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Add Item Touch Listener
        navigation_rv.addOnItemTouchListener(RecyclerTouchListener(this, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                when (position) {
                    0 -> {
                        // # Home Fragment

                    }
                    1 -> {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        val intent = Intent(this@MainActivity1, CartActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        // # Movies Fragment

                    }
                    3 -> {
                        // # Books Fragment

                    }
                    4 -> {
                        // # Profile Activity

                    }
                    5 -> {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        val intent = Intent(this@MainActivity1, ProfileActivity::class.java)
                        startActivity(intent)
                        // # Settings Fragment
                       /* val bundle = Bundle()
                        bundle.putString("fragmentName", "Settings Fragment")
                        val settingsFragment = DemoFragment()
                        settingsFragment.arguments = bundle
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_main_content_id, settingsFragment).commit()*/
                    }
                    6 -> {
                        // # Open URL in browser

                    }
                }
                // Don't highlight the 'Profile' and 'Like us on Facebook' item row
                updateAdapter(position)
                if (position != 6 && position != 4) {

                }
                Handler().postDelayed({
                    drawerLayout.closeDrawer(GravityCompat.START)
                }, 200)
            }
        }))

        // Update Adapter with item data and highlight the default menu item ('Home' Fragment)
        updateAdapter(0)

        // Set 'Home' as the default fragment when the app starts
      /*  val bundle = Bundle()
        bundle.putString("fragmentName", "Home Fragment")
        val homeFragment = DemoFragment()
        homeFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_content_id, homeFragment).commit()*/


        // Close the soft keyboard when you open or close the Drawer
        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            activity_main_toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View) {
                // Triggered once the drawer closes
                super.onDrawerClosed(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }

            override fun onDrawerOpened(drawerView: View) {
                // Triggered once the drawer opens
                super.onDrawerOpened(drawerView)
                try {
                    val inputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                    e.stackTrace
                }
            }
        }
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()


        // Set Header Image
       // navigation_header_img.setImageResource(R.drawable.logo)

        // Set background of Drawer
        navigation_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }

    private fun updateAdapter(highlightItemPos: Int) {
        adapter = NavigationRVAdapter(items,items1, highlightItemPos)
        navigation_rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            // Checking for fragment count on back stack
            if (supportFragmentManager.backStackEntryCount > 0) {
                // Go to the previous fragment
                supportFragmentManager.popBackStack()
            } else {
                // Exit the app
                super.onBackPressed()
            }
        }
    }

}