package com.metaled.DashBoardModule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.metaled.CartModule.CartActivity
import com.metaled.CategoryModule.CategoryActivity
import com.metaled.HomeModule.Adapters.BestSellerAdapter
import com.metaled.HomeModule.Adapters.ProductAdapter
import com.metaled.ProductModule.ProductActivity
import com.metaled.ProfileActivity
import com.metaled.R
import com.metaled.Signup
import com.metaled.Utils.ConstantUtils
import com.metaled.Utils.SharedPreferenceUtils
import com.metaled.WishListModule.WishListActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.dashboard_header.*
import kotlinx.android.synthetic.main.menu_footer.*
import kotlinx.android.synthetic.main.menu_header.*

class DashboardActivity : AppCompatActivity() {
    lateinit var bestsellerList:ArrayList<String>
    lateinit var productss:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        onclick()

        bestsellerList=ArrayList()
        bestsellerList.add("")
        bestsellerList.add("")
        bestsellerList.add("")
        bestsellerList.add("")
        setBestsellerList()
        productss=ArrayList()
        productss.add("")
        productss.add("")
        productss.add("")
        productss.add("")
        setProduct()
    }

    fun setBestsellerList(){
      rvBestSeller.layoutManager = LinearLayoutManager(this)
//        arrayList= ArrayList()
//        mylist= arrayListOf()
       rvBestSeller.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
       rvBestSeller.adapter= BestSellerAdapter(this, bestsellerList)
    }
    fun setProduct(){
       rvproducts.layoutManager = LinearLayoutManager(this)

       rvproducts.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
       rvproducts.adapter= ProductAdapter(this, productss)
    }

    fun onclick(){
        ivMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        ivCloseMenu.setOnClickListener {
            closeDrower()
        }

        llHome.setOnClickListener {
           closeDrower()
        }
        llCart.setOnClickListener {
            closeDrower()
            intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        llWishList.setOnClickListener {
            closeDrower()
            intent = Intent(this, WishListActivity::class.java)
            startActivity(intent)
        }
        llProduct.setOnClickListener {
            closeDrower()
            intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
        llCategories.setOnClickListener {
            closeDrower()
            intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }
        llProfile.setOnClickListener {
            closeDrower()
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        llLogout.setOnClickListener {
            SharedPreferenceUtils.getInstance(this)?.clear()
            intent = Intent(this, Signup::class.java)
            startActivity(intent)
            finishAffinity()
        }
        ivProfile1.setOnClickListener {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

    fun closeDrower(){
        drawerLayout.closeDrawer(GravityCompat.START)
    }

}