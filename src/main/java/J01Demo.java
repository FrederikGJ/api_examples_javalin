import io.javalin.Javalin;

public class J01Demo {

    public static void main(String[] args) {
    // lolo
        Javalin app = Javalin.create().start(7500);

        app.get("/lol", ctx -> ctx.result("lol... her må du ikke kigge"));

        app.get("/", ctx -> ctx.result("Hello World"));

        app.get("/hej", ctx -> {
            ctx.status(200);
            ctx.contentType("text/naonaonao");
            ctx.result("Hej med dig. Jeg hedder Magnus Tagmus");
        });


        //json fil virker ikke
        app.get("/json", ctx -> {
            ctx.status(200);
            ctx.contentType("application/json");
            ctx.json(new Message(200, "Hej med dig. Jeg hedder Magnus Tagmus"));
        });

        app.get("html", ctx -> {
            ctx.status(200);
            ctx.contentType("text/html");
            ctx.html("<h1>Hej med dig</h1>");
        });

        app.get("/render", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/render2", ctx -> {
            ctx.render("index2.jte");
        });

    }
}
