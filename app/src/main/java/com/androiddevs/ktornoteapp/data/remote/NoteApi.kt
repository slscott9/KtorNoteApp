package com.androiddevs.ktornoteapp.data.remote

import com.androiddevs.ktornoteapp.data.local.entities.Note
import com.androiddevs.ktornoteapp.data.remote.requests.AccountRequest
import com.androiddevs.ktornoteapp.data.remote.requests.AddOwnerRequest
import com.androiddevs.ktornoteapp.data.remote.requests.DeleteNoteRequest
import com.androiddevs.ktornoteapp.data.remote.responses.SimpleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import javax.annotation.PostConstruct

interface NoteApi {

    /*
        @Body allows retrofit to parse registerRequest to json format and send
        it with our register request to the ktor server where it parses the json back to
        a data class
     */

    @POST("/register")
    suspend fun register(@Body registerRequest: AccountRequest) : Response<SimpleResponse>


    @POST("/login")
    suspend fun login(@Body registerRequest: AccountRequest) : Response<SimpleResponse>


    @POST("/addNote")
    suspend fun addNote(@Body note: Note) : Response<ResponseBody>

    //we dont send any type of response back from ktor server so we use ResponseBody. We can just use request codes now
    @POST("/deleteNote")
    suspend fun deleteNote(@Body deleteNoteRequest: DeleteNoteRequest) : Response<ResponseBody>

    @POST("/addOwnerToNote")
    suspend fun addOwnerToNote(@Body addOwnerRequest: AddOwnerRequest) : Response<SimpleResponse>

    @GET("/getNotes")
    suspend fun getAllNotes() : Response<List<Note>>
}

