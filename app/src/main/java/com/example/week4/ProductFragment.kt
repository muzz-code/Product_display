package com.example.week4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.week4.adapter.DataAdapter
import com.example.week4.adapter.PartnersRvAdapter
import com.example.week4.model.Data
import com.example.week4.model.PartnersData
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_products.*

class ProductFragment : Fragment() {

    lateinit var viewPager: ViewPager2
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        viewPager = view.findViewById(R.id.viewPager2)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val debitCards = ArrayList<Data>()

        /*Add Debit Cards to List*/
        debitCards.add(Data("Darot", "23,764,133.00", R.color.black))
        debitCards.add(Data("Hope", "28,046,523.00", R.color.teal_200))
        debitCards.add(Data("Wilson", "25,313,414.00", R.color.black))
        debitCards.add(Data("Jesse", "24,133,393.00", R.color.teal_700))
        debitCards.add(Data("Mary", "22,133,642.00", R.color.black))

        /*Set-Up ViewPager Adapter*/
        val viewPagerAdapter = DataAdapter(debitCards)

        viewPager.apply {
            adapter = viewPagerAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2
            setPadding(150, 0, 150, 0)
        }

        val marginPageTransformer = MarginPageTransformer(30)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(marginPageTransformer)
        compositePageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }

        viewPager.setPageTransformer(compositePageTransformer)

        /*Set-Up Dot Indicator*/
        TabLayoutMediator(tabIndicator, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()

        /*Instantiate Partners List*/
        val partnersList = ArrayList<PartnersData>()

        partnersList.add(PartnersData("AliExpress", "from 4%", "Clothes and shoes"))
        partnersList.add(PartnersData("Aviasales", "from 4.8%", "Tickets and travels"))
        partnersList.add(PartnersData("Bookgram", "from 5.6%", "Booking and Scheduling"))
        partnersList.add(PartnersData("IbomAir", "from 9%", "Transport"))
        partnersList.add(PartnersData("SkyNet", "from 3.5%", "Tech"))
        partnersList.add(PartnersData("Jumia", "from 3.8%", "Clothes and shoes"))
        partnersList.add(PartnersData("Slot", "from 9%", "Mobile Phones"))
        partnersList.add(PartnersData("Apple", "from 6.2%", "Laptops"))
        partnersList.add(PartnersData("Target", "from 2.4%", "Merchandise"))

        /*Initialize Layout Manager and Adapter*/
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val recyclerViewAdapter = PartnersRvAdapter(partnersList)

        /*Set-Up RecyclerView Adapter*/
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerViewAdapter
    }

    companion object {
        fun newInstance() =
            ProductFragment()
    }
}
