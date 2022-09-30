package test.karpenko.counterwithcallback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import test.karpenko.counterwithcallback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClick {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.containerConstraint, CounterFragment())
            .commit()

    }

    override fun onShowInActivity(text: String) {
        binding.activityCounter.text = text
    }
}