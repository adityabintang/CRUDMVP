package com.bintang.crudmvp.tambah

import android.text.TextUtils
import com.bintang.crudmvp.tambah.model.NetworkClient
import com.bintang.crudmvp.tambah.model.ResponseTambah
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahPresenter(val view: TambahView) {
    fun tambah(NIK: String, Nama: String, Alamat: String, No_hp: String) {
        if(TextUtils.isEmpty(NIK)) {
            view.isEmpty("Tidak Boleh Kosong")
        }
        else if (TextUtils.isEmpty(Nama)) {
            view.isEmpty("Tidak Boleh Kosong")

        }
        else if(TextUtils.isEmpty(Alamat)) {
           view.isEmpty("Tidak Boleh Kosong")
        }
        else if (TextUtils.isEmpty(No_hp)) {
            view.isEmpty("Tidak Boleh Kosong")
        }
        else {
            NetworkClient.initService().tambahSiswa(NIK, Nama, Alamat, No_hp).enqueue(object : Callback<ResponseTambah>{
                override fun onResponse(call: Call<ResponseTambah>, response: Response<ResponseTambah>) {
                    if (response.isSuccessful) {
                        response.body()?.let { view.onSuccessTambah(it) }
                    }
                }

                override fun onFailure(call: Call<ResponseTambah>, t: Throwable) {
                    view.onErrorServer(t.localizedMessage)
                }

            })
        }
    }
}