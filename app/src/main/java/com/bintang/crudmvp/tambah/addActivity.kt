package com.bintang.crudmvp.tambah

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bintang.crudmvp.MainActivity
import com.bintang.crudmvp.R
import com.bintang.crudmvp.tambah.model.ResponseTambah
import com.bintang.crudmvp.tampil.TampilActivity
import kotlinx.android.synthetic.main.activity_add.*

class addActivity : AppCompatActivity(), TambahView {
    private var presenter : TambahPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        presenter = TambahPresenter(this)
        btnTambah.setOnClickListener {
            actionTambah()
        }
    }

    private fun actionTambah () {
        val NIK = tambahnik?.text.toString()
        val Nama = tambahnama?.text.toString()
        val Alamat = tambahalamat?.text.toString()
        val No_hp = tambahnohp?.text.toString()

        presenter?.tambah(NIK, Nama, Alamat, No_hp)
    }

    override fun isEmpty(msg: String) {
        AlertDialog.Builder(this)
                .setTitle("Peringatan")
                .setMessage("Tidak Boleh Kosong")
                .setNegativeButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->

                }).show()
    }

    override fun onSuccessTambah(response: ResponseTambah) {
        if (response.isSuccess == true) {
            val intent = Intent(this, TampilActivity::class.java)
            startActivity(intent)
            finish()
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