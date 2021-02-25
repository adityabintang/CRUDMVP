package com.bintang.crudmvp.tampil

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bintang.crudmvp.R
import com.bintang.crudmvp.tambah.addActivity
import com.bintang.crudmvp.tambah.model.NetworkClient
import com.bintang.crudmvp.tampil.adapter.TampilAdapter
import com.bintang.crudmvp.tampil.model.ResponseTampil
import kotlinx.android.synthetic.main.activity_tampil.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TampilActivity : AppCompatActivity(), TampilView{

    private var presenter: TampilPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil)

        presenter = TampilPresenter(this)
        presenter?.showSiswa()
        searchSiswa()
        btntambahactivity.setOnClickListener {
            val intent = Intent(this, addActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun searchSiswa() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        recyclerview.layoutManager = LinearLayoutManager(this)
        searchbox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = searchbox.text.toString()
                presenter?.searchSiswa(keyword)
            }
        })
    }

    override fun onSuccessTampil(response: ResponseTampil) {
        if (response.isSuccess == true) {
            recyclerview.adapter = response.data?.let { TampilAdapter(this, it) }

        }
        else {
            response.message
            AlertDialog.Builder(this)
                    .setTitle("")
                    .setMessage("Gagal")
                    .setNegativeButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->

                    }).show()
        }
        }

    override fun onErrorServer(msg: String) {
        AlertDialog.Builder(this)
                .setTitle("Informasi")
                .setMessage("Error Server")
                .setNegativeButton("OK", DialogInterface.OnClickListener{dialogINterface, i ->

                }).show()
    }

}