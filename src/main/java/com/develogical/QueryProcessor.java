package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        System.out.println(query);
        String response = "";
        if (query.contains(": hi")) {
            response = "hello";
        } else if (query.contains("what is your name")) {
            response = "A-Team";
        } else if (query.contains("Prime Minister")) {
            response = "David Cameron";
        } else if (query.contains("banana")) {
            response = "Yellow";
        } else if (query.contains("James Bond")) {
            response = "Sean Connery";
        } else if (query.contains("Spain") && query.contains("Euro")) {
            response = "Peseta";
        } else if (query.contains("Eiffel Tower")) {
            response = "Paris";
        } else if (query.contains("Fibonacci")) {
            String[] parts = query.split(" ");
            int term = Integer.parseInt(parts[4].replace("th", ""));
            response = new Integer(nthFibonacci(term)).toString();
        } else if (query.contains("what is") && query.contains("plus")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[5]);
            response = new Integer(a + b).toString();
        } else if (query.contains("what is") && query.contains("minus")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[5]);
            response = new Integer(a - b).toString();
        } else if (query.contains("what is") && query.contains("multiplied")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[6]);
            response = new Integer(a * b).toString();
        } else if (query.contains("what is") && query.contains("power")) {
            String[] parts = query.split(" ");
            int a = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[8]);
            response = new Integer((int) Math.pow(a, b)).toString();
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
        } else if (query.contains("primes:")) {
            int indexOfColon = query.lastIndexOf(':');
            String postColon = query.substring(indexOfColon + 1);
            String[] numbers = postColon.split(",");
            List<Integer> primes = new ArrayList<Integer>();
            for (String numString : numbers) {
                int num = Integer.parseInt(numString.trim());
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
            String primesString = "";
            for (int i=0; i< primes.size(); i++) {
                primesString += Integer.toString(primes.get(i));
                if (i != primes.size() - 1) {
                    primesString += ", ";
                }
            }
            return primesString;
        } else if (query.contains("square and a cube")) {
            int indexOfColon = query.lastIndexOf(':');
            String postColon = query.substring(indexOfColon + 1);
            String[] numbers = postColon.split(",");
            int result = -1;
            for (int i=0; i< numbers.length; i++) {
                String numString = numbers[i];
                int num = Integer.parseInt(numString.trim());
                double sqRoot = Math.sqrt(num);
                double cbRoot = Math.cbrt(num);
                if ((sqRoot - Math.floor(sqRoot) == 0) && (cbRoot - Math.floor(cbRoot) == 0)) {
                    result = num;
                }
            }
            response = result > -1 ? new Integer(result).toString() : "";
        }
        System.out.println("Reponse: " + response);
        return response;
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    
    int nthFibonacci(int n) {
        int[] fibs = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040}
        return fibs[n];
    }

}
