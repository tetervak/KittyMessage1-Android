package ca.tetervak.kittymessage1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.tetervak.kittymessage1.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener{showOutput()}
    }

    private fun showOutput(){
        // get urgent flag value
        val urgent = binding.urgentCheckBox.isChecked

        // get the selected message text
        val message = when (binding.messageGroup.checkedRadioButtonId) {
            R.id.purr_button -> getString(R.string.cat_purr)
            R.id.mew_button -> getString(R.string.cat_mew)
            R.id.hiss_button -> getString(R.string.cat_hiss)
            else -> getString(R.string.undefined)
        }

        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra(OutputActivity.IS_URGENT_KEY, urgent)
            putExtra(OutputActivity.MESSAGE_TEXT_KEY, message)
        }
        startActivity(intent)
    }
}