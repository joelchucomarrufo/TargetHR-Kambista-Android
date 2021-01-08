package pe.mowui.kambista.feature.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import pe.mowui.kambista.feature.home.HomeActivity
import pe.mowui.kambista.R
import pe.mowui.kambista.base.ViewModelFactory
import pe.mowui.kambista.core.data.api.ApiHelper
import pe.mowui.kambista.core.data.api.RetrofitBuilder
import pe.mowui.kambista.util.Constants.KEY_USER
import pe.mowui.kambista.util.Status

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initEvents()
        initViewModel()
    }

    private fun initEvents() {
        btnLogin.setOnClickListener {
            //progressBar.visibility = View.VISIBLE
            subscribeObserversLogin(etEmail.text.toString(), etPassword.text.toString())
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.kambistaApi))
        ).get(LoginViewModel::class.java)
    }

    private fun subscribeObserversLogin(user: String, password: String) {
        viewModel.login(user, password).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.let { loginResponse -> goToHome(user) }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun goToHome(user: String) {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.putExtra(KEY_USER, user)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}