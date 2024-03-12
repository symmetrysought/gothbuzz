package eu.symmetrysought.gothbuzz.shared.annotations

import eu.symmetrysought.gothbuzz.preprocessor.ExampleGenerated

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val generatedGreeting = ExampleGenerated.generatedMessage()
        return "Hello, ${platform.name}! Big things follow: $generatedGreeting"
    }
}