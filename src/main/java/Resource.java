// Definerer en public 'record' klasse ved navn 'Resource'.
// 'record' er en specialklasse i Java, der bruges til at modellere uforanderlige data i applikationer.
public record Resource(String data, String eTag) {

    // En alternativ konstruktør, der kun tager 'data' som parameter.
    // Dette er nyttigt, når du vil oprette en 'Resource' uden et eksisterende eTag.
    public Resource(String data) {
        // Kalder den primære konstruktør med 'data' og et nyt genereret eTag.
        // 'generateETag()' er en hjælpemetode, der skaber en ny unik streng (i dette tilfælde, et UUID).
        this(data, generateETag());
    }

    // En privat statisk metode, der genererer et unikt eTag ved hjælp af UUID.
    // UUID står for 'Universally Unique Identifier' og er bredt anvendt til at skabe unikke strenge.
    private static String generateETag() {
        // 'randomUUID()' genererer en tilfældig UUID og konverterer den til en streng.
        return java.util.UUID.randomUUID().toString();
    }
}
