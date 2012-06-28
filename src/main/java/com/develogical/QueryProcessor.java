package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi")) {
            return "hello";
        } else if (query.contains("what is your name")) {
            return "A-Team";
        }
        return "";
    }

}
