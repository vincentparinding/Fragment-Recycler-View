package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.example.myapplication.fragment.*

/**
 *  Nested Scroll View
 * */
class MainActivity2 : AppCompatActivity() {

    private val fragments = mutableListOf<BaseFragment>()

    companion object {
        private const val NEXT_ITEM = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fragments.add(Fragment1())
        fragments.add(Fragment2())
        fragments.add(Fragment3())
        fragments.add(Fragment4())
        fragments.add(Fragment5())
        fragments.add(Fragment6())
        fragments.add(Fragment7())
        fragments.add(Fragment8())
        fragments.add(Fragment1())
        fragments.add(Fragment2())
        fragments.add(Fragment3())

        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[0], "unique_1").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[1], "unique_2").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[2], "unique_3").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[3], "unique_4").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[4], "unique_5").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[5], "unique_6").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[6], "unique_7").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[7], "unique_8").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[8], "unique_1_2").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[9], "unique_2_2").commit()
        supportFragmentManager.beginTransaction().add(R.id.vg_container, fragments[10], "unique_3_2").commit()

        findViewById<NestedScrollView>(R.id.nested_scroll).let {
            it.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
                for (i in fragments.indices.reversed()) {
                    val y: Int = (fragments[i].view?.y?.toInt() ?: 0)
                    if (scrollY >= y) {
                        setContent(i)
                        break
                    }

                }
            }
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        setFirstContent()
        return super.onCreateView(name, context, attrs)
    }

    private fun setFirstContent() {
        for (i in 1..NEXT_ITEM) {
            setContent(i * -1)
        }
    }

    private fun setContent(position: Int) {
        val nextPosition = position + NEXT_ITEM
        if (nextPosition < fragments.size) {
            Log.d("asdasd", "reach: "+ fragments[nextPosition].javaClass.simpleName)
            fragments[nextPosition].setContent(fragments[nextPosition].tag ?: "")
        }
    }

}