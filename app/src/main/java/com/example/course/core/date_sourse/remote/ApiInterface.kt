package com.example.course.core.date_sourse.remote

import com.example.course.core.model.body.Comment
import com.example.course.core.model.body.LoginBodyRequest
import com.example.course.core.model.body.Post
import com.example.course.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    //gson will back name's"ResponseUserList"
    @GET("posts")
    suspend fun getPosts() :Response<ArrayList<Post>>

    // query optional 3ady
  @GET("posts")
  suspend fun getPostByUser(@Query("userId") userId :Int): Response<ArrayList<Post>>


    //path part of url w not optional
    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId : Int) : Response<ArrayList<Comment>>


  @POST("auth/login")
  suspend fun login(@Body body: LoginBodyRequest) : Response<UserResponse>


}
