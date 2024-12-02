package edu.vt.cs5254.fancygallery.api

import android.net.Uri
import androidx.lifecycle.LifecycleOwner
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    val title: String,
    val id: String,
    @Json(name = "url_s") val url: String,
    val owner: String,
){
    val photoPageUri: Uri = Uri.parse("https://www.flickr.com/photos/")
        .buildUpon()
        .appendPath(owner)
        .appendPath(id)
        .build()

}
//https://www.flickr.com/photos/{user-id}/{photo-id}