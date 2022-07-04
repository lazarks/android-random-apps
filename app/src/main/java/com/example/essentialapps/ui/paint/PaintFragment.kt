package com.example.essentialapps.ui.paint

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.essentialapps.R
import com.example.essentialapps.databinding.FragmentPaintBinding

class PaintFragment : Fragment() {

    companion object {
        fun newInstance() = PaintFragment()
    }

    private var _binding: FragmentPaintBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: PaintViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val paintViewModel =
            ViewModelProvider(this)[PaintViewModel::class.java]

        _binding = FragmentPaintBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPaint
        paintViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[PaintViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}