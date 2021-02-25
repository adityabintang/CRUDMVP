package com.bintang.crudmvp.tambah.model

import com.bintang.crudmvp.detail.model.ResponseHapus
import com.bintang.crudmvp.edit.model.ResponseEdit
import com.bintang.crudmvp.tampil.model.ResponseTampil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class NetworkClient {
    companion object {
        fun getClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
            return client
        }
        fun getRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.10.5:8000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build()
            return retrofit
        }
        fun initService(): RestApi{

            return getRetrofit().create(RestApi::class.java)
        }
    }
}

interface RestApi {
    @FormUrlEncoded
    @POST("addSiswa")
    fun tambahSiswa(
            @Field("NIK") NIK: String,
            @Field("Nama") Nama: String,
            @Field("Alamat") Alamat: String,
            @Field("No_hp") No_hp: String
    ) : Call<ResponseTambah>

    @FormUrlEncoded
    @POST("editSiswa/{id}")
    fun editSiswa(
            @Path("id") id: Int,
            @Field("NIK") NIK: String,
            @Field("Nama") Nama: String,
            @Field("Alamat") Alamat: String,
            @Field("No_hp") No_hp: String
    ): Call<ResponseEdit>
    @GET("getSiswa")
    fun tampilSiswa(): Call<ResponseTampil>
    @GET("searchSiswa")
    fun searchSiswa(
            @Query("q") keyword: String
    ): Call<ResponseTampil>

    @FormUrlEncoded
    @POST("deleteSiswa")
    fun deleteSiswa(
            @Field("id") id: Int
    ):Call<ResponseHapus>
}