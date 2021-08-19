package com.example.myapplication5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.myapplication5.databinding.MainScreenFragmentBinding
import com.yuyakaido.android.cardstackview.*


class MainScreenFragment: Fragment() {
    private lateinit var binding: MainScreenFragmentBinding
    private lateinit var manager: CardStackLayoutManager
    private lateinit var cardStackView: CardStackView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {

        binding = MainScreenFragmentBinding.inflate(inflater)
        manager = CardStackLayoutManager(context)
        cardStackView = binding.cardStackView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardStackViewInitialize()
    }

    private fun cardStackViewInitialize() {
        manager.setStackFrom(StackFrom.None)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(false)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.itemAnimator = DefaultItemAnimator()
    }
}