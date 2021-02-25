package com.bintang.crudmvp.tambah.model

import com.google.gson.annotations.SerializedName

data class ResponseTambah(

	@field:SerializedName("data")
	val data: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
