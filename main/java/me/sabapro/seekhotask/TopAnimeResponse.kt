package me.sabapro.seekhotask


data class TopAnimeResponse(
    val data: ArrayList<Anime>
)

data class Anime(
    val title: String,
    val episodes: String,
    val score: String,
    val images: Images,

    val trailer: Video,
    val synopsis : String,
//    val name : String
)

data class Images(
    val jpg: Jpg
)

data class Jpg(
    val image_url: String
)

data class Video(
    val url : String
)

//data class Genres(
//    val name : String
//)

