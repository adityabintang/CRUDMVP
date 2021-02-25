package com.bintang.crudmvp.edit.model

import com.google.gson.annotations.SerializedName

data class ResponseEdit(

	@field:SerializedName("input")
	val input: Input? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

data class Input(

	@field:SerializedName("Alamat")
	val alamat: String? = null,

	@field:SerializedName("NIK")
	val nIK: Int? = null,

	@field:SerializedName("Nama")
	val nama: String? = null,

	@field:SerializedName("No_hp")
	val noHp: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
