package co.id.egiwibowo.imovie.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetails(
    val movieId: Int,
    val title: String,
    val posterPath: String,
    val overview: String,
    val backdropPath: String,
    val voteCount: Int,
    val rating: String,
    val releaseDate: String,
    val runtime: String,
    val genres: List<Genre>,
    val casts: List<Cast>,
    val originalTitle: String,
    val status: String,
    val budget: String,
    val revenue: String,
    val recommend: List<RecommendMovie>
) : Parcelable {

    @Parcelize
    data class Genre(
        val id: Int,
        val name: String
    ): Parcelable

    @Parcelize
    data class Cast(
        val castId: Int,
        val character: String,
        val name: String,
        val profilePath: String?
    ) : Parcelable

    @Parcelize
    data class RecommendMovie(
        val movieId: Int,
        val title: String,
        val rating: String,
        val posterPath: String
    ) : Parcelable

    val year: String = let {
        val dateParts: List<String> = it.releaseDate.split("-")
        dateParts[0]
    }
}