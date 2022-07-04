package com.example.essentialapps.ui.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.essentialapps.databinding.FragmentPaintBinding

class PaintFragment : Fragment() {
    private var _binding: FragmentPaintBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PaintFragment()
        var path = Path()
        var paintBrush = Paint()
    }

    private lateinit var viewModel: PaintViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[PaintViewModel::class.java]
        _binding = FragmentPaintBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val redBtn = binding.redColor
        val blueBtn = binding.blueColor
        val blackBtn = binding.blackColor
        val eraser = binding.whiteColor

        redBtn.setOnClickListener{
            Toast.makeText(requireContext(), "red color selected", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }

        blueBtn.setOnClickListener{
            Toast.makeText(requireContext(), "blue color selected", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        blackBtn.setOnClickListener{
            Toast.makeText(requireContext(), "black color selected", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }

        eraser.setOnClickListener{
            Toast.makeText(requireContext(), "eraser selected", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.WHITE
            PaintView.pathList.clear()
            PaintView.colorList.clear()
            path.reset()
        }

//        return inflater.inflate(R.layout.fragment_paint, container, false)
        return root
    }

    private fun currentColor(color: Int){
        PaintView.currentBrush = color
        path = Path()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}