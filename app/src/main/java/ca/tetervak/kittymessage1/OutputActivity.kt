package ca.tetervak.kittymessage1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.tetervak.kittymessage1.databinding.ActivityOutputBinding
import ca.tetervak.kittymessage1.model.Envelope

class OutputActivity : AppCompatActivity() {

    companion object{
        const val ENVELOPE = "envelope"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get and display the message data
        binding.envelope = intent.getSerializableExtra(ENVELOPE) as Envelope

        // make the close button work
        binding.closeButton.setOnClickListener { finish() }
    }
}