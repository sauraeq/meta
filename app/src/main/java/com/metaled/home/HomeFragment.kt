package com.example.myapplication2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.metaled.HomeModule.Adapters.BestSellerAdapter
import com.metaled.HomeModule.Adapters.ProductAdapter
import com.metaled.databinding.FragmentHomeBinding

import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var bestsellerList:ArrayList<String>
    lateinit var productss:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        /* val textView: TextView = binding.textHome
         homeViewModel.text.observe(viewLifecycleOwner) {
             textView.text = it
         }*/

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
        // val img_profile: ImageView? = view?.findViewById(R.id.img_profile)
/*
        img_profile?.setOnClickListener {
            val intent=Intent(context,ProfileActivity::class.java)
            startActivity(intent)
        }
*/
        // val img_menu: ImageView? = view?.findViewById(R.id.img_menu)
/*
        img_menu?.setOnClickListener() {
            var intent= Intent(context,sidebar_activity::class.java)
            startActivity(intent)

        }
*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setBestsellerList(){
        binding.rvBestSeller.layoutManager = LinearLayoutManager(requireContext())
//        arrayList= ArrayList()
//        mylist= arrayListOf()
        binding.rvBestSeller.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.rvBestSeller.adapter= BestSellerAdapter(requireContext(), bestsellerList)
    }
    fun setProduct(){
        binding.rvproducts.layoutManager = LinearLayoutManager(activity)

        binding.rvproducts.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rvproducts.adapter= ProductAdapter(requireContext(), productss)
    }



}