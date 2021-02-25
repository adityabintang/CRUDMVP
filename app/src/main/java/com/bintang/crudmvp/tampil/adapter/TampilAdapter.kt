package com.bintang.crudmvp.tampil.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bintang.crudmvp.R
import com.bintang.crudmvp.detail.DetailActivity
import com.bintang.crudmvp.tampil.adapter.TampilAdapter.*
import com.bintang.crudmvp.tampil.model.DataItem
import kotlinx.android.synthetic.main.item_activity.view.*
import kotlin.contracts.Returns

class TampilAdapter(val context: Context, val dataItem: List<DataItem?>): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_activity, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        dataItem.get(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", dataItem.get(position)?.id)
            intent.putExtra("NIK", dataItem.get(position)?.nik)
            intent.putExtra("Nama", dataItem.get(position)?.nama)
            intent.putExtra("Alamat", dataItem.get(position)?.alamat)
            intent.putExtra("No_hp", dataItem.get(position)?.nohp)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataItem.size
    }

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(itemData: DataItem) {
            itemView.nik.text = "NIK :"+itemData.nik
            itemView.nama.text = "Nama :"+itemData.nama
            itemView.alamat.text = "Alamat :"+itemData.alamat
            itemView.nohp.text = "No_hp :"+itemData.nohp
        }
    }


}

