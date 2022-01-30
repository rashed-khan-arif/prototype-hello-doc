package com.hello.hellodoc

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter


class DocPagerAdapter : PagerAdapter() {
    private val mFragmentList: MutableList<Fragment> = ArrayList()
    private val mFragmentTitleList: MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }
}