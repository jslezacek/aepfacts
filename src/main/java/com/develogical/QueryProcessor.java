package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("hi")) {
            return "hello";
        } else if (query.contains("what is your name")) {
            return "A-Team";
        } else if (query.startsWith("what is") && query.contains("plus")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[2]);
            int b = Integer.parseInt(parts[4]);
            return new Integer(a + b).toString();
        }
        return "";
    }

}
