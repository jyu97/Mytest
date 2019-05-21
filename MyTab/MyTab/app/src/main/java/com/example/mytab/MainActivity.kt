package com.example.mytab

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.mytab.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ItemFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
    }

    private val adapter by lazy { MyAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vpMainActivity.adapter = MainActivity@adapter
        vpMainActivity.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_1_black)
                tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_2_black)

                when(position) {

                    0   ->    tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_1)
                    1   ->    tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_2)
                }
            }
        })

        // 탭 레이아웃에 뷰페이저 연결
        tabLayout.setupWithViewPager(vpMainActivity)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_1)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_2_black)
    }
}
