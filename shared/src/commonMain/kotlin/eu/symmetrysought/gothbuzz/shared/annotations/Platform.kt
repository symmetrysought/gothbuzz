package gothbuzz.shared.annotations

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform