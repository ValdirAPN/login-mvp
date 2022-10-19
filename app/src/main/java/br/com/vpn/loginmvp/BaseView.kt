package br.com.vpn.loginmvp

interface BaseView<T> {
    var presenter : T
    fun bindViews()
}