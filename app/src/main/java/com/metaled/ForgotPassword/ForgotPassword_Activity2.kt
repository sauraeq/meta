package com.metaled.ForgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.API.APIUtils
import com.metaled.AuthenticationModel.ForgetPassModels.ChangePassResponse
import com.metaled.AuthenticationModel.VeriFyotpModels.VerifyOtpResponse
import com.metaled.R
import com.metaled.Signup
import kotlinx.android.synthetic.main.activity_forgot_2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class ForgotPassword_Activity2 : AppCompatActivity() {
    var userid=""
    var newPass=""
    var confPass=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_2)
        userid=intent.getStringExtra("userid").toString()

        tvSave.setOnClickListener() {
            newPass=etPassword.text.toString()
            confPass=etcnfmPassword.text.toString()
            if(newPass.isEmpty()){
                Toast.makeText(this,"Plaese enter password ", Toast.LENGTH_LONG).show()
            }else if(confPass.isEmpty()){
                Toast.makeText(this,"Plaese enter  Confirm password", Toast.LENGTH_LONG).show()

            }else if(!newPass.equals(confPass)){
                Toast.makeText(this," Password  and confirm Password not matched", Toast.LENGTH_LONG).show()
            }else{
                changepass()
            }


        }
    }

    fun changepass() {
        /*{"customer_id":"45", "new_password":"1234567", "confirm_password":"1234567"}*/
        val request = HashMap<String, String>()
        request.put("customer_id", userid)
        request.put("new_password", newPass)
        request.put("confirm_password", confPass)
        rlLoader.visibility = View.VISIBLE

        var call: Call<ChangePassResponse> = APIUtils.getServiceAPI()!!.changepassword(request)

        call.enqueue(object : Callback<ChangePassResponse> {
            override fun onResponse(
                call: Call<ChangePassResponse>,
                response: Response<ChangePassResponse>
            ) {
                try {

                     rlLoader.visibility = View.GONE
                    if (response.body()!!.success.equals("true")) {
                        Toast.makeText(this@ForgotPassword_Activity2,response.body()!!.msg.toString(),Toast.LENGTH_LONG).show()
                        intent = Intent(this@ForgotPassword_Activity2, Signup::class.java)
                        startActivity(intent)
                        finishAffinity()

                    } else {
                        Toast.makeText(this@ForgotPassword_Activity2,response.body()!!.msg.toString(),Toast.LENGTH_LONG).show()

                    }

                } catch (e: Exception) {
                    Log.e("saurav", e.toString())
                    rlLoader.visibility = View.GONE
                    Toast.makeText(this@ForgotPassword_Activity2,e.toString(),Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<ChangePassResponse>, t: Throwable) {
                Log.e("Saurav", t.message.toString())
                rlLoader.visibility = View.GONE
                Toast.makeText(this@ForgotPassword_Activity2,t.toString(),Toast.LENGTH_LONG).show()

            }

        })
    }


}