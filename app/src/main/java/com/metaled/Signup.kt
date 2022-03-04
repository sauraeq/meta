package com.metaled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import com.API.APIUtils
import com.metaled.AuthenticationModel.LoginModel.LoginResponse
import com.metaled.AuthenticationModel.SignUpModel.SignUpResponse
import com.metaled.DashBoardModule.DashboardActivity
import com.metaled.ForgotPassword.Forgot_Activity
import com.metaled.Utils.ConstantUtils
import com.metaled.Utils.NetworkUtils
import com.metaled.Utils.SharedPreferenceUtils

import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.header_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class Signup : AppCompatActivity() {
    var name=""
    var emailid=""
    var mobile=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        click()
    }

    fun click() {
        tvSignUpTab.setOnClickListener() {
            tvSignUpTab.setBackgroundResource(R.drawable.rectangle_black)
            tvSignUpTab.setTextColor(resources.getColor(R.color.white))
            tvSiginTab.setBackgroundResource(R.drawable.white_shape)
            tvSiginTab.setTextColor(resources.getColor(R.color.light_gray))
            llSignUp.visibility = View.VISIBLE
            llSignIn.visibility = View.GONE

        }
        tvSiginTab.setOnClickListener() {
            tvSignUpTab.setBackgroundResource(R.drawable.white_shape)
            tvSignUpTab.setTextColor(resources.getColor(R.color.light_gray))
            tvSiginTab.setBackgroundResource(R.drawable.rectangle_black)
            tvSiginTab.setTextColor(resources.getColor(R.color.white))
            llSignUp.visibility = View.GONE
            llSignIn.visibility = View.VISIBLE

        }
        tvSignin.setOnClickListener() {

            emailid=etSignEmail.text.toString()
            password=etSignPassword.text.toString()

            if(emailid.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzemail),
                    Toast.LENGTH_LONG).show()
            }else if(password.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzpass),
                    Toast.LENGTH_LONG).show()
            }else{

                if(NetworkUtils.checkInternetConnection(this))
                {
                    login()
                }


            }


        }


        tvSignup.setOnClickListener() {
            name=etName.text.toString()
            emailid=etEmail.text.toString()
            mobile=etMobile.text.toString()
            password=etPassword.text.toString()


            if(emailid.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzemail),
                    Toast.LENGTH_LONG).show()
            }else if(password.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzpass),
                    Toast.LENGTH_LONG).show()
            }
            else if(mobile.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzmobile),
                    Toast.LENGTH_LONG).show()
            }
            else if(name.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzname),
                    Toast.LENGTH_LONG).show()
            }else{
                if(NetworkUtils.checkInternetConnection(this))
                {
                    signup()
                }


            }



            /*if(name.isEmpty()){
                Toast.makeText(this,resources.getString(R.string.plzname),Toast.LENGTH_LONG).show()
            }else if(emailid.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzemail),
                    Toast.LENGTH_LONG).show()
            }else if(mobile.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzmobile),
                    Toast.LENGTH_LONG).show()
            }else if(password.isEmpty()){
                Toast.makeText(this,resources.getString(com.metaled.R.string.plzpass),
                    Toast.LENGTH_LONG).show()
            }else{
                intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }*/




        }


        forgot_password.setOnClickListener() {
           intent = Intent(this, Forgot_Activity::class.java)
            startActivity(intent)


        }
    }
    fun signup()
    {
        rlLoader.visibility=View.VISIBLE
        val stringStringHashMap = HashMap<String, String>()
        stringStringHashMap.put("fullname",name)
        stringStringHashMap.put("mobile",mobile)
        stringStringHashMap.put("email",emailid)
        stringStringHashMap.put("password",password)
        stringStringHashMap.put("conform_password",password)
        stringStringHashMap.put("address","")
        stringStringHashMap.put("signuptype","1")
        stringStringHashMap.put("g_id","")
        stringStringHashMap.put("fb_id","")
        stringStringHashMap.put("tw_id","")

        var signup: Call<SignUpResponse> = APIUtils.getServiceAPI()!!.SignUp(stringStringHashMap)

        signup.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                try {

                    rlLoader.visibility=View.GONE
                    if (response.body()!!.success.equals("true")) {
                        login()

                        /*   var intent = Intent(this@SignupLoginActivity, DashboardActivity::class.java)
                            startActivity(intent)

                         */






                    } else {

                        rlLoader.visibility=View.GONE

                    }

                }  catch (e: Exception) {
                    Log.e("saurav", e.toString())
                    Toast.makeText(this@Signup,e.message.toString(),Toast.LENGTH_LONG).show()
                    rlLoader.visibility=View.GONE
                }

            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e("Saurav", t.message.toString())
                Toast.makeText(this@Signup,t.message.toString(),Toast.LENGTH_LONG).show()
                rlLoader.visibility=View.GONE

            }

        })
    }

    fun login()
    {
        val request = HashMap<String, String>()
        request.put("email",emailid)
        request.put("password",password)
        request.put("signuptype","1")
        request.put("g_id","")
        request.put("fb_id","")
        request.put("tw_id","")
        rlLoader.visibility=View.VISIBLE

        var signin: Call<LoginResponse> = APIUtils.getServiceAPI()!!.LogIn(request)

        signin.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                try {

                    rlLoader.visibility=View.GONE
                    if (response.body()!!.success.equals("true")) {
                        SharedPreferenceUtils.getInstance(this@Signup)?.setStringValue(ConstantUtils.USER_ID,response.body()!!.data.user_id)
                        SharedPreferenceUtils.getInstance(this@Signup)?.setStringValue(ConstantUtils.EMAIL_ID,response.body()!!.data.email)
                        SharedPreferenceUtils.getInstance(this@Signup)?.setStringValue(ConstantUtils.IS_LOGIN,"true")
                        var intent = Intent(this@Signup, DashboardActivity::class.java)
                        startActivity(intent)
                        finishAffinity()

                    } else {
                        Toast.makeText(this@Signup,response.body()!!.msg.toString(),Toast.LENGTH_LONG).show()

                    }

                }  catch (e: Exception) {
                    Log.e("saurav", e.toString())
                    rlLoader.visibility=View.GONE

                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Saurav", t.message.toString())
                rlLoader.visibility=View.GONE

            }

        })
    }
}