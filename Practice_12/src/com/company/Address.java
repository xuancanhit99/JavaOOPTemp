package com.company;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String housing;
    private String apartment;

    public Address(String line) {
        Pattern pattern = Pattern.compile("^[\\w,\\s]+$");
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()){
            String[] words = line.split(",\\s?");
            country   = words[0].trim();
            region    = words[1].trim();
            city      = words[2].trim();
            street    = words[3].trim();
            house     = words[4].trim();
            housing   = words[5].trim();
            apartment = words[6].trim();
        } else {
            StringTokenizer tokenizer = new StringTokenizer(line, ",.;-");
            country   = tokenizer.nextToken().trim();
            region    = tokenizer.nextToken().trim();
            city      = tokenizer.nextToken().trim();
            street    = tokenizer.nextToken().trim();
            house     = tokenizer.nextToken().trim();
            housing   = tokenizer.nextToken().trim();
            apartment = tokenizer.nextToken().trim();
        }
    }

    public void print() {
        System.out.println("Country: "   + country  );
        System.out.println("Region: "    + region   );
        System.out.println("City: "      + city     );
        System.out.println("Street: "    + street   );
        System.out.println("House: "     + house    );
        System.out.println("Housing: "   + housing  );
        System.out.println("Apartment: " + apartment);
        System.out.println();
    }
}