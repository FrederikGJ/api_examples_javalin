import io.javalin.Javalin;

public class J02Demo {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7500);

        // query param
        app.get("/query", ctx -> {
            String name = ctx.queryParam("name");
            String age = ctx.queryParam("age");
            ctx.result("Hello " + name + " age " + age);
        });

        //pathParam
        app.get("/path/{name}/{age}/{lastname}", ctx -> {
            String name = ctx.pathParam("name");
            String age = ctx.pathParam("age");
            String lastname = ctx.pathParam("lastname");
            ctx.result("Hello " + name + " age " + age + " lastname " + lastname);
        });



    }
}
