package Steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


    public class APITests_Test {
/*
        private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        private static final String USERNAME = "TOOLSQA-Test";
        private static final String PASSWORD = "Test@@123";
        private static final String BASE_URL = "https://bookstore.toolsqa.com";

        private static String token;
        private static Response response;
        private static String jsonString;
        private static String bookId;


        @Given("I am an authorized user")
        public void iAmAnAuthorizedUser() {

            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();

            request.header("Content-Type", "application/json");
            response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                    .post("/Account/v1/GenerateToken");

            String jsonString = response.asString();
            token = JsonPath.from(jsonString).get("token");

        }

        @Given("A list of books are available")
        public void listOfBooksAreAvailable() {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            response = request.get("/BookStore/v1/Books");

            jsonString = response.asString();
            List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
            Assert.assertTrue(books.size() > 0);

            bookId = books.get(0).get("isbn");
        }

        @When("I add a book to my reading list")
        public void addBookInList() {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json");

            response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                    "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                    .post("/BookStore/v1/Books");
        }

        @Then("The book is added")
        public void bookIsAdded() {
            Assert.assertEquals(201, response.getStatusCode());
        }

        @When("I remove a book from my reading list")
        public void removeBookFromList() {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();

            request.header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json");

            response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
                    .delete("/BookStore/v1/Book");


        }

        @Then("The book is removed")
        public void bookIsRemoved() {
            Assert.assertEquals(204, response.getStatusCode());

            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();

            request.header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json");

            response = request.get("/Account/v1/User/" + USER_ID);
            Assert.assertEquals(200, response.getStatusCode());

            jsonString = response.asString();
            List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
            Assert.assertEquals(0, booksOfUser.size());
        }
*/

        private  static  final  String  BASE_URL  =  "https://www.loginradius.com";
        String email = "abcxyz@mail7.io";
        String password = "password";
        RequestSpecification request;
        private  static  Response response;
        private  static  String  jsonString;

        @Given("Post Login API")
        public void post_login_api() {
            RestAssured.baseURI  =  BASE_URL;
            request  =  RestAssured.given();
            request.header("Content-Type",  "application/json");
        }

        @When("Provide Valid Credential")
        public void provide_valid_credential() {
            response  =  request.body("{ \"userName\":\""  +  email  +  "\", \"password\":\""  +  password  +  "\"}")
                    .post("/user/login");
        }

        @Then("Status_code equals {int}")
        public void statuscode_equals_(int agr) {
            Assert.assertEquals(String.valueOf(agr), response.getStatusCode());
        }

        @And("response contains IsPosted equals {string}")
        public void response_contains_IsPosted_equals_(String message) {
            Assert.assertEquals(message, getJsonPath(response, "IsPosted"));
        }

        @And("response contains message equals {string}")
        public void response_contains_equals_(String message) {
            Assert.assertEquals(message, getJsonPath(response, "message"));
        }

        @When("Provide different combinations to {string}{string}")
        public void provide_different_combinations_to_somethingsomething(String email, String password){
            response = request.body("{ \"userName\":\"" + email + "\", \"password\":\"" + password + "\"}") .post("/user/login");
        }

        public String getJsonPath(Response response, String key) {
            String resp = response.asString();
            JsonPath js = new JsonPath(resp);
            return js.get(key).toString();
        }

    }

