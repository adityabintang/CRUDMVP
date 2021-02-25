package com.bintang.crudmvp.edit

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bintang.crudmvp.MainActivity
import com.bintang.crudmvp.R
import com.bintang.crudmvp.edit.model.ResponseEdit
import com.bintang.crudmvp.tampil.TampilActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_edit_actvitiy.*

class EditActvitiy : AppCompatActivity(), EditView {
    private var presenter: EditPresenter? = null
    private var id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_actvitiy)

        id = intent.getIntExtra("id", 0)
        editnik.setText(intent.getStringExtra("NIK"))
        editnama.setText(intent.getStringExtra("Nama"))
        editalamat.setText(intent.getStringExtra("Alamat"))
        editnohp.setText(intent.getStringExtra("No_hp"))

        presenter = EditPresenter(this)
        btnedit.setOnClickListener {
            actionEdit()
        }
    }

    private fun actionEdit() {
        val NIK = editnik?.text.toString()
        val Nama = editnama?.text.toString()
        val Alamat = editalamat?.text.toString()
        val No_hp = editnohp?.text.toString()

        presenter?.edit(id?: 0, NIK, Nama, Alamat, No_hp)
    }

    override fun onSuccessEdit(response: ResponseEdit) {
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
                    .setNegativeButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->

                    }).show()
        }
    }

    override fun onIsEmptyEdit(msg: String) {
        AlertDialog.Builder(this)
                .setTitle("Peringatan")
                .setMessage("Tidak Boleh Kosong")
                .setNegativeButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->

                }).show()
    }

    override fun onErrorServer(msg: String) {
        AlertDialog.Builder(this)
                .setTitle("Informasi")
                .setMessage("Error Server")
                .setNegativeButton("OK", DialogInterface.OnClickListener{dialogINterface, i ->

                }).show()
    }

}