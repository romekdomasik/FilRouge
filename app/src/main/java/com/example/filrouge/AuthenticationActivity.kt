package com.example.filrouge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import com.example.filrouge.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConnect.setOnClickListener {
            var email = binding.champEmail.text
            var pwd = binding.champPassword.text
            if (!email.isNullOrBlank() && !pwd.isNullOrBlank()){
                displayHomeActivity()
            } else{
                alert("Vérifiez mot de passe et/ou email", "Erreur")
            }

        }
    }

    fun displayHomeActivity(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun alert(message: String, title: String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setTitle(title)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun toggleEmailValidity(isValid: Boolean) {
        if(isValid) {
            binding.layoutEmail.isErrorEnabled = false
            binding.champEmail.setTextColor(
                ResourcesCompat.getColor(resources, R.color.text_input_valid_text_color,
                theme))
        } else {
            binding.layoutEmail.error = getString(R.string.email_error_hint)
            binding.layoutEmail.isErrorEnabled = true
            binding.champEmail.setTextColor(ResourcesCompat.getColor(resources, R.color.black, theme))
        } }



}