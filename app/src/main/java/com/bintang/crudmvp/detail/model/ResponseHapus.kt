package com.bintang.crudmvp.detail.model

import com.google.gson.annotations.SerializedName

data class ResponseHapus(

	@field:SerializedName("response_status")
	val responseStatus: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
