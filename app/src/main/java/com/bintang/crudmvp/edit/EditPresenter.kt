package com.bintang.crudmvp.edit

import android.text.TextUtils
import com.bintang.crudmvp.edit.model.ResponseEdit
import com.bintang.crudmvp.tambah.model.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditPresenter(val view: EditView) {
    fun edit(id: Int?,NIK: String, Nama: String, Alamat: String, No_hp: String) {
        if(TextUtils.isEmpty(NIK)) {
            view.onIsEmptyEdit("Tidak Boleh Kosong")
        }
        else if(TextUtils.isEmpty(Nama)) {
            view.onIsEmptyEdit("Tidak Boleh Kosong")
        }
        else if(TextUtils.isEmpty(Alamat)) {
            view.onIsEmptyEdit("Tidak Boleh Kosong")
        }
        else if (TextUtils.isEmpty(No_hp)) {
            view.onIsEmptyEdit("Tidak Boleh Kosong")
        }
        else {
            NetworkClient.initService().editSiswa(id?:0, NIK, Nama, Alamat, No_hp).enqueue(object : Callback<ResponseEdit>{
                override fun onResponse(call: Call<ResponseEdit>, response: Response<ResponseEdit>) {
                    if(response.isSuccessful) {
                        response.body()?.let { view.onSuccessEdit(it) }
                    }
                }

                override fun onFailure(call: Call<ResponseEdit>, t: Throwable) {
                    view.onErrorServer(t.localizedMessage)
                }

            })
        }
    }
}