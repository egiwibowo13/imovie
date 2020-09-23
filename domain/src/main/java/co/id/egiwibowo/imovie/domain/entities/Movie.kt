package co.id.egiwibowo.imovie.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val title: String,
    val posterPath: String,
    val overview: String,
    val backdropPath: String,
    val voteCount: Int,
    val voteAverage: Float,
    val releaseDate: String,
    val isFavorite: Boolean
) : Parcelable