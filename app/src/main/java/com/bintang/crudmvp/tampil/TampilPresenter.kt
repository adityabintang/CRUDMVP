package com.bintang.crudmvp.tampil

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.bintang.crudmvp.tambah.model.NetworkClient
import com.bintang.crudmvp.tampil.adapter.TampilAdapter
import com.bintang.crudmvp.tampil.model.DataItem
import com.bintang.crudmvp.tampil.model.ResponseTampil
import kotlinx.android.synthetic.main.activity_tampil.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TampilPresenter(val view: TampilView) {
    private lateinit var dataItemList: List<DataItem?>
    fun showSiswa() {
        NetworkClient.initService().tampilSiswa().enqueue(object : Callback<ResponseTampil>{
            override fun onResponse(call: Call<ResponseTampil>, response: Response<ResponseTampil>) {
                if(response.isSuccessful) {
                    response.body()?.let { view.onSuccessTampil(it) }
                    dataItemList = response.body()?.data!!
                }
            }

            override fun onFailure(call: Call<ResponseTampil>, t: Throwable) {
                view.onErrorServer(t.localizedMessage)
            }

        })

    }
    fun searchSiswa(keyword: String) {
        NetworkClient.initService().searchSiswa(keyword).enqueue(object : Callback<ResponseTampil>{

            override fun onResponse(call: Call<ResponseTampil>, response: Response<ResponseTampil>) {
                if (response.isSuccessful){
                    response.body()?.let { view.onSuccessTampil(it) }

                }
            }

            override fun onFailure(call: Call<ResponseTampil>, t: Throwable) {
                view.onErrorServer(t.localizedMessage)
            }

        })
    }

}
