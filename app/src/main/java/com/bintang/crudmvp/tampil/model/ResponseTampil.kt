package com.bintang.crudmvp.tampil.model

import com.google.gson.annotations.SerializedName

data class ResponseTampil(

	@field:SerializedName("response_status")
	val responseStatus: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

data class DataItem(

	@field:SerializedName("Alamat")
	val alamat: String? = null,

	@field:SerializedName("NIK")
	val nik: Int? = null,

	@field:SerializedName("Nama")
	val nama: String? = null,

	@field:SerializedName("No_hp")
	val nohp: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
