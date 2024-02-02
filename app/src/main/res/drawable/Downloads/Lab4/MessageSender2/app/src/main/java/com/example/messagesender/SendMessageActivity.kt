package com.example.messagesender

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.messagesender.databinding.ActivitySendMessageBinding

class SendMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding: ActivitySendMessageBinding

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        binding = ActivitySendMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSendText.setOnClickListener {
            val phoneNo = binding.etPhoneNumber.text.toString()
            val message =binding.etMessageText.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:$phoneNo") // This ensures only SMS apps handle this
                putExtra("sms_body", message)
            }
          startActivity(intent)
    }
}
    }