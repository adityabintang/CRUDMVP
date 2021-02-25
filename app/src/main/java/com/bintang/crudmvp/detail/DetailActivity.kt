package com.bintang.crudmvp.detail

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bintang.crudmvp.R
import com.bintang.crudmvp.detail.model.ResponseHapus
import com.bintang.crudmvp.edit.EditActvitiy
import com.bintang.crudmvp.tambah.TambahPresenter
import com.bintang.crudmvp.tampil.TampilActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView{
    private var presenter: DetailPresenter? = null
    private var id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter = DetailPresenter(this)

        id = intent.getIntExtra("id", 0)
        detailnik.text = intent.getStringExtra("NIK")
        detailnama.text = intent.getStringExtra("Nama")
        detailalamat.text = intent.getStringExtra("Alamat")
        detailnohp.text = intent.getStringExtra("No_hp")

        btnedit.setOnClickListener {
            actionEdit()
        }

        btnhapus.setOnClickListener {
            actionHapus()
        }
    }

    private fun actionEdit() {
        val intent = Intent(this, EditActvitiy::class.java)
        intent.putExtra("id", id)
        intent.putExtra("NIK", detailnik.text)
        intent.putExtra("Nama", detailnama.text)
        intent.putExtra("Alamat", detailalamat.text)
        intent.putExtra("No_hp", detailnohp.text)
        startActivity(intent)
    }
    private fun  actionHapus() {
        presenter?.hapus(id?:0)
    }

    override fun onSuccess(response: ResponseHapus) {
        if(response.isSuccess == true) {
            val intent = Intent(this, TampilActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onError(msg: String) {
        AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("Error")
                .setNegativeButton("OK", DialogInterface.OnClickListener{dialogInterface, i ->

                }).show()
    }
}