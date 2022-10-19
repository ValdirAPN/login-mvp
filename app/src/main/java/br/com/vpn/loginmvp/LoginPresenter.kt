package br.com.vpn.loginmvp

class LoginPresenter(
    private val view: LoginContract.View
) : LoginContract.Presenter {

    override fun start() {
        view.bindViews()
    }

    override fun isLoginValid(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            view.displayErrorMessage()
        } else {
            if (username == AuthUtils.USERNAME && password == AuthUtils.PASSWORD) {
                view.displaySuccessToast()
                view.startHomeActivity()
            } else {
                view.displayErrorMessage()
            }
        }
    }
}