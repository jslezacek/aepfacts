package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        System.out.println(query);
        String response = "";
        if (query.contains(": hi")) {
            response = "hello";
        } else if (query.contains("what is your name")) {
            response = "A-Team";
        } else if (query.contains("what is") && query.contains("plus")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[5]);
            response = new Integer(a + b).toString();
        } else if (query.contains("largest:")) {
            int indexOfColon = query.lastIndexOf(':');
            String postColon = query.substring(indexOfColon + 1);
            String[] numbers = postColon.split(",");
            int maxInt = Integer.MIN_VALUE;
            for (String numString : numbers) {
                int num = Integer.parseInt(numString.trim());
                if (num > maxInt) {
                    maxInt = num;
                }
            }
            response = new Integer(maxInt).toString();
        }
        System.out.println("Reponse: " + response);
        return response;
    }

}
