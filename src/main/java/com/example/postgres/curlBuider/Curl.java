package com.example.postgres.curlBuider;

public class Curl {


    public String curlStringGenerator(String name) {

        String curlString = "curl -x 127.0.0.1:8080" +
                "-XPOST " +
                "'{" +
                "name: " +
                "{" +
                "'name': '%s'" +
//                ", 'model': 'LE-311V'," +
//                "'make': 'Ciena'," +
//                "'identifier': '09ZD07207807'," +
//                "'domainname': 'comcast.net'," +
//                "'status':'REPLACEMENT_PENDING'" +
                "}" +
                "}'";
        return String.format(curlString, name);
    }
}
