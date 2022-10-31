package uz.bdm.podcast.screen.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.bdm.podcast.screen.main.MainActivity
import uz.bdm.podcast.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}