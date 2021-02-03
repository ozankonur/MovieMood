package com.rokon.moviemood.ui.fresh

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rokon.moviemood.R

class FreshFragment : Fragment() {

    companion object {
        fun newInstance() = FreshFragment()
    }

    private lateinit var viewModel: FreshViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fresh_fragment, container, false)
    }

}