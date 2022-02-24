package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TwitterAPITest {

    @Test
    public void TweetTest() {

        Response response = RestAssured.given()
                .auth()
                .oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=GoopodddmornigW");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println(response.getTime());
        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();
        String id_str = jsonPath.getString("id_str");
        System.out.println("================");
        System.out.println(id_str);

    }

    @Test

    public void retweetTest() {
        Response response = RestAssured.given()
                .auth()
                .oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .post("https://api.twitter.com/1.1/statuses/retweet/1496733838512312322.json");

        System.out.println("Response code: " + response.getStatusCode());
        System.out.println(response.getTime());
        response.prettyPrint();
    }

    @Test
    public void deleteTest(){
        Response response = RestAssured.given()
                .auth()
                .oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .delete("https://api.twitter.com/2/tweets/1496724056774934529");

        System.out.println("Response code: " + response.getStatusCode());
        System.out.println(response.getTime());
        response.prettyPrint();
    }

}
