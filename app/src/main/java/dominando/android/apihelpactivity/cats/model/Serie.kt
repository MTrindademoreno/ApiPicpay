package dominando.android.apihelpactivity.cats.model

data class Serie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)