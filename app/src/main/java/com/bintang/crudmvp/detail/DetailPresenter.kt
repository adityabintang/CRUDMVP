package com.bintang.crudmvp.detail

import com.bintang.crudmvp.detail.model.ResponseHapus
import com.bintang.crudmvp.tambah.model.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(val view: DetailView) {
    fun hapus(id: Int) {
        NetworkClient.initService().deleteSiswa(id).enqueue(object : Callback<ResponseHapus> {
            override fun onResponse(call: Call<ResponseHapus>, response: Response<ResponseHapus>) {
                if (response.isSuccessful) {
                    val result = response.body()?.isSuccess
                    val pesan = response.body()?.message
                    if (result == true) {

                        val data = response.body()
                        data?.let { view.onSuccess(it) }

                    }

                }
            }
            override fun onFailure(call: Call<ResponseHapus>, t: Throwable) {

                t.message?.let { view.onError(it) }
            }
        })
    }
}