import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class J03Demo {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7500);

        app.routes(() -> {
            path("/person", () -> {
                get("/", ctx -> ctx.json(new Message(200, "ROOT")));
                get("/all", ctx -> ctx.json(new Message(200, "GET ALL")));

                });
            });

        app.routes(() -> {
            path("/user", () -> {
                get("/", ctx -> ctx.json(new Message(200, "USER ROOT")));
                get("/all", ctx -> ctx.json(new Message(200, "USER ALL")));
            });
        });

        app.routes(() -> {
            path("/cow", () -> {
                get("/", ctx -> ctx.json(new Message(200, "COW ROOT")));
                get("/all", ctx -> ctx.json(new Message(200, "COW ALL - GET ALL THE COWS")));
            });
        });



    }
}
