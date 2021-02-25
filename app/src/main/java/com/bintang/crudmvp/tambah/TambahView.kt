package com.bintang.crudmvp.tambah

import com.bintang.crudmvp.tambah.model.ResponseTambah

interface TambahView {
    fun isEmpty(msg: String)
    fun onSuccessTambah(response: ResponseTambah)
    fun onErrorServer(msg: String)
}