package com.example.mytab

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

class MyAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm)  {

    private val fragmentTitleList = mutableListOf("일정","리스트")

    override fun getItem(position: Int): Fragment? {

        return when(position) {

            0       ->  BlankFragment()

            1       ->  ItemFragment()

            else    ->  null
        }

    }

    // 생성 할 Fragment 의 개수
    override fun getCount() = 2

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        //Log.e("FragmentPagerAdapter", "destroyItem position : $position")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null //fragmentTitleList[position]
    }

}