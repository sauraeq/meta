package com.metaled.Splash
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.metaled.DashBoardModule.DashboardActivity

import com.metaled.R
import com.metaled.Signup
import com.metaled.Utils.ConstantUtils
import com.metaled.Utils.SharedPreferenceUtils


@Suppress("DEPRECATION")

class Splash :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            if (SharedPreferenceUtils.getInstance(this)?.getStringValue(ConstantUtils.IS_LOGIN,"").equals("true")) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)



            }else{
                val intent = Intent(this, Signup::class.java)
                startActivity(intent)

            }
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}