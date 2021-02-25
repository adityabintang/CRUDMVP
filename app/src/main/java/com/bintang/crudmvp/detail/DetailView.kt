package com.bintang.crudmvp.detail

import com.bintang.crudmvp.detail.model.ResponseHapus

interface DetailView {

    fun onSuccess(response: ResponseHapus)
    fun onError(msg : String)
}