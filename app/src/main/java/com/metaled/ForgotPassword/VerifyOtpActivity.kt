package com.metaled.ForgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.API.APIUtils
import com.metaled.AuthenticationModel.VeriFyotpModels.VerifyOtpResponse
import com.metaled.R
import com.metaled.Utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_forgot.*
import kotlinx.android.synthetic.main.activity_otp1.*
import kotlinx.android.synthetic.main.activity_signup.rlLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class VerifyOtpActivity : AppCompatActivity() {
    var userid=""
    var otp=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp1)
        userid=intent.getStringExtra("userid").toString()

        tv_verify.setOnClickListener() {
            otp=et_pin_1.text.toString()+""+et_pin_2.text.toString()+""+et_pin_3.text.toString()+""+et_pin_4.text.toString()
           if(otp.isEmpty()){
              Toast.makeText(this,"Plaese enter OTP",Toast.LENGTH_LONG).show()
           }else if(otp.length!=4){
               Toast.makeText(this,"Plaese enter Correct OTP",Toast.LENGTH_LONG).show()
           }else{
               if (NetworkUtils.checkInternetConnection(this))
               {
                   verifyotp()
               }

           }



        }
    }

    fun verifyotp() {
        /*{"customer_id":"45", "otp":"123456"}*/
        val request = HashMap<String, String>()
        request.put("customer_id", userid)
        request.put("otp", otp)
        rlLoader.visibility = View.VISIBLE

        var call: Call<VerifyOtpResponse> = APIUtils.getServiceAPI()!!.verifyotp(request)

        call.enqueue(object : Callback<VerifyOtpResponse> {
            override fun onResponse(
                call: Call<VerifyOtpResponse>,
                response: Response<VerifyOtpResponse>
            ) {
                try {

                    rlLoader.visibility = View.GONE
                    if (response.body()!!.success.equals("true")) {
                        intent = Intent(this@VerifyOtpActivity, ForgotPassword_Activity2::class.java)
                        intent.putExtra("userid",userid)
                        startActivity(intent)

                    } else {


                    }

                } catch (e: Exception) {
                    Log.e("saurav", e.toString())
                    rlLoader.visibility = View.GONE

                }

            }

            override fun onFailure(call: Call<VerifyOtpResponse>, t: Throwable) {
                Log.e("Saurav", t.message.toString())
                rlLoader.visibility = View.GONE

            }

        })
    }

}