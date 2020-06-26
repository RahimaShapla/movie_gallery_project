package com.pro.movie.utils.helper


import com.itechsoftsolution.ebay.utils.helper.DataUtils
import com.pro.movie.R


class Constants {
    class Invalid {
        companion object {
            const val INVALID_INTEGER: Int = -1
        }
    }

    class Default {
        companion object {
            const val DEFAULT_STRING: String = ""
            const val DEFAULT_INTEGER: Int = 0
            const val DEFAULT_LONG: Long = 0
            const val DEFAULT_BOOLEAN: Boolean = false
            const val SPLASH_DELAY_TIME = 2000

        }
    }

    class Common {
        companion object {
            const val ANDROID_HASH_KEY = "Hash Key"
            const val COMMON_TIME_ZONE = "UTC"
            const val APP_COMMON_DATE_FORMAT: String = "dd MMMM, yyyy"
            const val APP_COMMON_ONLY_DATE_FORMAT: String = "dd MMMM, yyyy"
            const val APP_COMMON_TIME_FORMAT: String = "hh:mm a"
            const val APP_COMMON_DAY_FORMAT: String = "E"
            const val APP_COMMON_MONTH_FORMAT: String = "MMM"

        }
    }


    class File {
        companion object {
            val DIRECTORY_ROOT = DataUtils.getString(R.string.app_name)
            val PREFIX_IMAGE = "IMG_"
            val PREFIX_CROPPED_IMAGE = "IMG_CROPPED_"
            val SUFFIX_IMAGE = ".jpg"
        }
    }


    class IntentKey {
        companion object {
            const val MOVIE_ID = "movie_id"
            const val VIDEO_KEY = "keyy"
        }
    }

    class JsonKey {
        companion object {
            const val RESULTS = "results"
            const val POPULARITY = "popularity"
            const val VOTE_COUNT = "vote_count"
            const val POSTER_PATH = "poster_path"
            const val ID = "id"
            const val ORIGINAL_TITLE = "original_title"
            const val VOTE_AVG = "vote_average"
            const val OVERVIEW = "overview"
            const val RELEASE_DATE = "release_date"
            const val RUNTIME = "runtime"
            const val KEY = "key"
            const val NAME = "name"
            const val API_KEY = "apiKey"
        }
    }
    class ServerUrl {
        companion object {
            const val BASE_URL = "http://api.themoviedb.org/3/movie/"
            const val MOVIE_LIST = "results"
            const val MOVIE_DETAIL = "popularity"
            const val TRAILER_LIST = "vote_count"

        }
    }


}