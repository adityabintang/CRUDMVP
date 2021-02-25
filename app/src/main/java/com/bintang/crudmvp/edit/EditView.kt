package com.bintang.crudmvp.edit

import com.bintang.crudmvp.edit.model.ResponseEdit

interface EditView {
    fun onSuccessEdit(response: ResponseEdit)
    fun onIsEmptyEdit(msg: String)
    fun onErrorServer(msg: String)
}