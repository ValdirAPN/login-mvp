package br.com.vpn.loginmvp

interface LoginContract {

    interface View : BaseView<LoginPresenter> {
        fun displayErrorMessage()
        fun displaySuccessToast()
        fun startHomeActivity()
    }

    interface Presenter : BasePresenter {
        fun isLoginValid(username: String, password: String)
    }
}