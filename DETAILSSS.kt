package com.example.fragment_traning

import com.google.gson.annotations.SerializedName

data class DETAILSSS(
    @SerializedName("achievements_count")
    val achievements_count: Int,
    @SerializedName("added")
    val added: Int,
    @SerializedName("added_by_status")
    val added_by_status: AddedByStatusX,
    @SerializedName("additions_count")
    val additions_count: Int,
    @SerializedName("alternative_names")
    val alternative_names: List<String>,
    @SerializedName("background_image")

    val background_image: String,
    @SerializedName("background_image_additional")
    val background_image_additional: String,
    @SerializedName("clip")
    val clip: Any,
    @SerializedName("creators_count")
    val creators_count: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_raw")
    val description_raw: String,
    @SerializedName("developers")

    val developers: List<Developer>,
    @SerializedName("dominant_color")

    val dominant_color: String,
    @SerializedName("esrb_rating")

    val esrb_rating: EsrbRatingX,
    @SerializedName("game_series_count")

    val game_series_count: Int,
    @SerializedName("genres")

    val genres: List<GenreX>,
    @SerializedName("id")

    val id: Int,
    @SerializedName("metacritic")

    val metacritic: Int,
    @SerializedName("metacritic_platforms")
    val metacritic_platforms: List<MetacriticPlatform>,
    @SerializedName("metacritic_url")

    val metacritic_url: String,
    @SerializedName("movies_count")

    val movies_count: Int,
    @SerializedName("name")

    val name: String,
    @SerializedName("name_original")

    val name_original: String,
    @SerializedName("parent_achievements_count")

    val parent_achievements_count: Int,
    @SerializedName("parent_platforms")

    val parent_platforms: List<ParentPlatformX>,
    @SerializedName("parents_count")

    val parents_count: Int,
    @SerializedName("platforms")

    val platforms: List<PlatformXXXXX>,
    @SerializedName("playtime")

    val playtime: Int,
    @SerializedName("publishers")

    val publishers: List<Publisher>,
    @SerializedName("rating")

    val rating: Double,
    @SerializedName("rating_top")

    val rating_top: Int,
    @SerializedName("ratings")

    val ratings: List<RatingX>,
    @SerializedName("ratings_count")

    val ratings_count: Int,
    @SerializedName("reactions")

    val reactions: Reactions,
    @SerializedName("reddit_count")

    val reddit_count: Int,
    @SerializedName("reddit_description")

    val reddit_description: String,
    @SerializedName("reddit_logo")

    val reddit_logo: String,
    @SerializedName("reddit_name")

    val reddit_name: String,
    @SerializedName("reddit_url")

    val reddit_url: String,
    @SerializedName("released")

    val released: String,
    @SerializedName("reviews_count")

    val reviews_count: Int,
    @SerializedName("reviews_text_count")

    val reviews_text_count: Int,
    @SerializedName("saturated_color")

    val saturated_color: String,
    @SerializedName("screenshots_count")

    val screenshots_count: Int,
    @SerializedName("slug")

    val slug: String,
    @SerializedName("stores")

    val stores: List<StoreXX>,
    @SerializedName("suggestions_count")

    val suggestions_count: Int,
    @SerializedName("tags")

    val tags: List<TagX>,
    @SerializedName("tba")

    val tba: Boolean,
    @SerializedName("twitch_count")

    val twitch_count: Int,
    @SerializedName("updated")

    val updated: String,
    @SerializedName("user_game")

    val user_game: Any,
    @SerializedName("website")

    val website: String,
    @SerializedName("youtube_count")

    val youtube_count: Int,


)