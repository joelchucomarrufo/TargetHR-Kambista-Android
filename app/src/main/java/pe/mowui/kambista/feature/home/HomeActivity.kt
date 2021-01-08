package pe.mowui.kambista.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import pe.mowui.kambista.R
import pe.mowui.kambista.util.Constants.KEY_USER

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        showUser(intent?.extras?.getString(KEY_USER).orEmpty())
    }

    private fun showUser(user: String) {
        tvEmail.text = user
    }
}