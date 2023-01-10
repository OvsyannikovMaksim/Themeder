package com.themeder.themeder.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.themeder.themeder.CardStackViewAdapter
import com.themeder.themeder.PhotoInfo
import com.themeder.themeder.databinding.FragmentPhotosBinding
import com.yuyakaido.android.cardstackview.*

class PhotosFragment : Fragment(), CardStackListener {

    private lateinit var binding: FragmentPhotosBinding
    private lateinit var cardStackView: CardStackView
    private lateinit var mLayout: CardStackLayoutManager
    private lateinit var mAdapter: CardStackViewAdapter

    // test photos
    private var photos: List<PhotoInfo> = listOf(PhotoInfo(Uri.parse("https://catherineasquithgallery.com/uploads/posts/2021-02/1612678074_74-p-kartinka-fon-zelenii-lug-125.jpg")))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLayout = CardStackLayoutManager(context?.applicationContext, this)
        mAdapter = CardStackViewAdapter()
        cardStackView = binding.cardStackView
        setupCardStackView()
        mAdapter.submitList(photos)
    }

    private fun setupCardStackView() {
        mLayout.setStackFrom(StackFrom.None)
        mLayout.setVisibleCount(3)
        mLayout.setTranslationInterval(8.0f)
        mLayout.setScaleInterval(0.95f)
        mLayout.setSwipeThreshold(0.3f)
        mLayout.setMaxDegree(20.0f)
        mLayout.setDirections(Direction.HORIZONTAL)
        mLayout.setCanScrollHorizontal(true)
        mLayout.setCanScrollVertical(true)
        mLayout.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        mLayout.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = mLayout
        cardStackView.adapter = mAdapter
        cardStackView.itemAnimator = DefaultItemAnimator()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        // no need to implement
    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardRewound() {
        // no need to implement
    }

    override fun onCardCanceled() {
        // no need to implement
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Log.d("PhotosFragment: onCardAppeared", "onCardAppeared $position")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        // no need to implement
    }
}
