package br.com.vpn.loginmvp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter: LoginPresenter

    private lateinit var loginInput : TextInputEditText
    lateinit var passwordInput : TextInputEditText
    private lateinit var btnLogin : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_login)

        presenter = LoginPresenter(this)

        presenter.start()

        btnLogin.setOnClickListener {
            val login = loginInput.text.toString()
            val password = passwordInput.text.toString()

            presenter.isLoginValid(login, password)
        }
    }

    override fun displayErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        loginInput.error = "Login Failed!"
        passwordInput.error = "Login Failed!"
    }

    override fun displaySuccessToast() {
        Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
    }

    override fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun bindViews() {
        loginInput = findViewById(R.id.et_login)
        passwordInput = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.buttonLogin)
    }
}