package com.metaled.ForgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.API.APIUtils
import com.metaled.AuthenticationModel.LoginModel.ForgotResponse1
import com.metaled.R
import com.metaled.Utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_forgot.*


import kotlinx.android.synthetic.main.activity_signup.tvSignup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class Forgot_Activity : AppCompatActivity() {
    var emailid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        tvSignup.setOnClickListener() {
            emailid = et_email_forgot.text.toString()

            if(emailid.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzemail),
                    Toast.LENGTH_LONG).show()
            }else{
                if (NetworkUtils.checkInternetConnection(this)) {
                    forgotpassword()

                }
            }



        }

    }

    fun forgotpassword() {
        val request = HashMap<String, String>()
        request.put("email", emailid)
        rlLoader.visibility = View.VISIBLE

        var call: Call<ForgotResponse1> = APIUtils.getServiceAPI()!!.forgotpassword(request)

        call.enqueue(object : Callback<ForgotResponse1> {
            override fun onResponse(
                call: Call<ForgotResponse1>,
                response: Response<ForgotResponse1>
            ) {
                try {

                    rlLoader.visibility = View.GONE
                    if (response.body()!!.success.equals("true")) {

                        intent = Intent(this@Forgot_Activity, VerifyOtpActivity::class.java)
                        intent.putExtra("userid",response.body()!!.data.customer_id)
                        startActivity(intent)
                    } else {


                    }

                } catch (e: Exception) {
                    Log.e("saurav", e.toString())
                    rlLoader.visibility = View.GONE

                }

            }

            override fun onFailure(call: Call<ForgotResponse1>, t: Throwable) {
                Log.e("Saurav", t.message.toString())
                rlLoader.visibility = View.GONE

            }

        })
    }

}