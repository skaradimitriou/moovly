package com.stathis.moovly.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.stathis.moovly.models.actor.Actor
import com.stathis.moovly.models.cast.MovieCastFeed
import com.stathis.moovly.models.genres.MovieGenresFeed
import com.stathis.moovly.models.movies.Movies
import com.stathis.moovly.models.movies.UpcomingMovies
import com.stathis.moovly.models.reviews.ReviewsFeed
import com.stathis.moovly.models.series.TvSeriesFeed
import com.stathis.moovly.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val api = Retrofit.Builder().baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Endpoints::class.java)

    suspend fun getCountries(): Response<UpcomingMovies> {
        return api.getUpcomindMovies()
    }

    suspend fun getTrendingMovies(): Response<UpcomingMovies> {
        return api.getTrendingMovies()
    }

    suspend fun getMovieGenres(): Response<MovieGenresFeed> {
        return api.getMovieGenres()
    }

    suspend fun getTopRatedMovies(): Response<UpcomingMovies> {
        return api.getTopRatedMovies()
    }

//    suspend fun getQueryInfo(query: String): Response<SearchItemsFeed> {
//        return api.getQueryInfo(query)
//    }

    fun getFeaturedTvSeries(): Call<TvSeriesFeed> {
        return api.getFeaturedTvSeries()
    }

    fun getAiringTodayTvSeries(): Call<TvSeriesFeed> {
        return api.getAiringTodayTvSeries()
    }

    fun getTopRatedTvSeries(): Call<TvSeriesFeed> {
        return api.getTopRatedTvSeries()
    }

    fun getPopularTvSeries(): Call<TvSeriesFeed> {
        return api.getPopularTvSeries()
    }

    fun getTvGenres(): Call<MovieGenresFeed> {
        return api.getTvGenres()
    }

    fun getResultsForThisGenre(genreId: Int, data : MutableLiveData<List<Movies>>, error : MutableLiveData<Boolean>) {
        api.getResultsForThisGenre(genreId).enqueue(object : Callback<UpcomingMovies> {
            override fun onResponse(call: Call<UpcomingMovies>, response: Response<UpcomingMovies>) {
                Log.d("", response.body().toString())
                data.postValue(response.body()?.results)
                error.postValue(false)
            }

            override fun onFailure(call: Call<UpcomingMovies>, t: Throwable) {
                error.postValue(true)
            }
        })
    }

    suspend fun getMovieCastInfo(movieId: Int) : Response<MovieCastFeed> {
        return api.getMovieCastInfo(movieId)
    }

    suspend fun getMovieReviews(movieId: Int) : Response<ReviewsFeed> {
        return api.getMovieReviews(movieId)
    }

    suspend fun getTvCastInfo(tvSeriesId: Int): Response<MovieCastFeed> {
        return api.getTvCastInfo(tvSeriesId)
    }

    suspend fun getTvReviews(tvSeriesId: Int): Response<ReviewsFeed> {
        return api.getTvReviews(tvSeriesId)
    }

    fun getActorInfo(actorId: Int): Call<Actor> {
        return api.getActorInfo(actorId)
    }

//    fun getActorsKnownMovies(actorId: Int): Call<KnownMoviesFeed> {
//        return api.getActorsKnownMovies(actorId)
//    }
}