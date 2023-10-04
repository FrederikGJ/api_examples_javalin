import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class J04Demo {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7500);

        app.before(ctx -> {
            System.out.println("Before we get going !!!!! ***********");
            System.out.println(ctx.url());
            System.out.println(ctx.scheme());
            String requestInfo = ctx.url();
            ctx.attribute("requestInfo", requestInfo);
        });

        app.get("/", ctx -> {
            System.out.println("**** a GET req was made by some client *****");
            ctx.result("Hello J 04 demo and so on");
        });

        app.after(ctx -> {
            System.out.println("After the party?? --- ");
            //System.out.println(ctx.url());
            //System.out.println(ctx.scheme());

        });

        app.get("/film", getFilm());
        app.get("/message", getMessage());
        app.get("/greeting", J04Demo::getGreeting);


    }

    public static void getGreeting(Context ctx) {

        ctx.result("Hello SHIT");
    }

    public static Handler getFilm(){
        return new Handler() {
            @Override
            public void handle(@NotNull Context ctx){
                ctx.json(new Message(333, "Besked der sked"));
            }
        };
    }

    public static Handler getMessage (){
        return ctx ->{
            ctx.json(new Message(333, "get message funktionen"));
        };
    }
}
