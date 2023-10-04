import io.javalin.Javalin;

public class J05Demo {

    public static void main(String[] args) {

        // Opretter en ny instans af 'Javalin' og starter serveren på port 7500.
        Javalin app = Javalin.create().start(7500);

        // Opretter en ny 'Resource'-instans med "Hello World" som data.
        // eTag vil blive genereret automatisk af den sekundære konstruktør i 'Resource'-klassen.
        Resource storedETag = new Resource("Hello World");

        // Definerer en ny GET-rute til "/my/resource".
        app.get("/my/resource", ctx -> {

            // Henter "If-None-Match" header fra HTTP-requesten.
            // Denne header anvendes typisk til at tjekke, om den klient-side cachelagrede version af en ressource er opdateret.
            String ifNoneMatch = ctx.header("If-None-Match");

            // Tjekker om 'ifNoneMatch' ikke er null og om det matcher eTag'en for den gemte ressource.
            if (ifNoneMatch != null && ifNoneMatch.equals(storedETag.eTag())) {

                // Sætter HTTP-statuskoden til 304 (Not Modified), hvis eTag'en matcher.
                // Dette informerer klienten om, at den cachelagrede version stadig er gyldig.
                ctx.status(304); // Not Modified

            } else {

                // Hvis eTag'en ikke matcher, betyder det, at ressourcen skal opdateres på klienten.

                // Sætter "ETag" headeren i HTTP-responsen med eTag-værdien fra den gemte ressource.
                ctx.header("ETag", storedETag.eTag());

                // Returnerer ressourceindholdet i HTTP-responsen.
                // Her kan du returnere det faktiske indhold af din ressource.
                ctx.result("Your resource content goes here");
            }
        });
    }
}


