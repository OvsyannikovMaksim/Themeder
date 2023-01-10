package com.themeder.themeder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.themeder.themeder.databinding.FragmentPhotosBinding
import com.yuyakaido.android.cardstackview.CardStackView

class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding
    private lateinit var cardStackView: CardStackView

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
        cardStackView = binding.cardStackView
    }
}
