package com.example.tahniaapps.Message.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tahniaapps.R

class TutorialFragmentAdapter : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial_adapter, container, false)
    }
    class TutorialFragmentAdapter (
        activity: TutorialMessageActivity,
        private val fragments: List<Fragment>
    )  : FragmentStateAdapter(activity)  {
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }
}