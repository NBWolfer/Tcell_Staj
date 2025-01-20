package org.example.spring_framework.middleware;

public abstract class Middleware {
    private Middleware next;

    public static Middleware chain(Middleware first, Middleware... middlewares) {
        Middleware head = first;

        for (Middleware middleware : middlewares) {
            head.next = middleware;
            head = middleware;
        }
        return first;
    }

    public abstract boolean check(String mail, String password);

    protected boolean checkNext(String mail, String password) {
        return next != null && next.check(mail, password);
    }
}
