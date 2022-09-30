package test.karpenko.counterwithcallback

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import test.karpenko.counterwithcallback.databinding.FragmentCounterBinding
import java.lang.Exception

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private var counter = 0
    private var onShowInActivity: OnClick? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.increaseCounterButton.setOnClickListener {
            counter++
            binding.counterText.text = counter.toString()
        }


        binding.button.setOnClickListener {
            onShowInActivity?.onShowInActivity(binding.counterText.text.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onShowInActivity = context as OnClick
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}