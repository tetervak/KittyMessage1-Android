package ca.tetervak.kittymessage1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.tetervak.kittymessage1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    companion object{
        const val MESSAGE_TEXT_KEY = "message"
        const val IS_URGENT_KEY = "urgent"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get and display the message data
        val urgent = intent.getBooleanExtra(IS_URGENT_KEY, true)
        binding.isUrgentOutput.text =
            getString(if (urgent) R.string.urgent else R.string.not_urgent)
        binding.messageText.text = intent.getStringExtra(MESSAGE_TEXT_KEY)

        // make the close button work
        binding.closeButton.setOnClickListener { finish() }
    }
}