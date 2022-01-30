package com.hello.hellodoc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hello.hellodoc.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QnAFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_qn_a, container, false)
        setupViewPager()
        return root
    }

    private fun setupViewPager() {
        val viewPager: ViewPager2 = root.findViewById<ViewPager2>(R.id.pager)
        viewPager.isSaveEnabled = false
        val tabs: TabLayout = root.findViewById<TabLayout>(R.id.tab_layout)
        val adapter = MyViewPagerAdapter(childFragmentManager, lifecycle)
        adapter.addFragment(QuestionFragment(), "Top Questions")
        adapter.addFragment(QuestionFragment(), "Top Secrets")
        viewPager.adapter = adapter
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QnAFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class MyViewPagerAdapter(manager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(manager, lifecycle) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }


        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        fun getPageTitle(position: Int): CharSequence {
            return titleList[position]
        }
    }


}