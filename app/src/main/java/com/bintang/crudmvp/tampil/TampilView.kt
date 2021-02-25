package com.bintang.crudmvp.tampil

import com.bintang.crudmvp.tampil.model.ResponseTampil

interface TampilView {
    fun onSuccessTampil(response: ResponseTampil)
    fun onErrorServer(msg: String)

}