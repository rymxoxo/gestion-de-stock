package com.rymchaouch.gestion_de_stock.config;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlickrConfiguration {

    @Value("${flickr.apiKey}") // Annotation that injects the value of the flickr.apiKey property into the apiKey variable
    private String apiKey ;

    @Value("${flickr.apiSecret}") // Annotation that injects the value of the flickr.apiSecret property into the apiSecret variable
    private String apiSecret ;
    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

  //cette methode de generer le app secret et appkey


    /*@Bean // Annotation that indicates Spring to manage this bean
    public Flickr getFLickr() throws IOException, ExecutionException, InterruptedException, FlickrException {
        Flickr flickr= new Flickr(apiKey,apiSecret,new REST()); // Create a new instance of Flickr with the provided API key and API secret
        OAuth10aService service = new ServiceBuilder(apiKey) // Create an OAuth10aService object with the API key
                .apiSecret(apiSecret) // Set the API secret
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE)); // Build the Flickr service specifying DELETE permission

        final Scanner scanner= new Scanner(System.in); // Create a Scanner object for user input
        final OAuth1RequestToken requestToken = service.getRequestToken(); // Retrieve the OAuth1 request token
        final String authUrl = service.getAuthorizationUrl(requestToken); // Retrieve the authorization URL for the user
        System.out.println(authUrl); // Print the authorization URL
        System.out.println("paste it here >>"); // Prompt the user to paste the authorization URL
        final String authVerifier = scanner.nextLine(); // Retrieve the authorization verification code entered by the user

        OAuth1AccessToken accessToken = service.getAccessToken(requestToken, authVerifier); // Retrieve the OAuth1 access token

        System.out.println(accessToken.getToken()); // Print the access token
        System.out.println(accessToken.getTokenSecret()); // Print the access token secret
        Auth auth = flickr.getAuthInterface().checkToken(accessToken); // Check the access token with Flickr's authentication interface
        System.out.println("---------------------------"); // Print a separating line
        System.out.println(auth.getToken()); // Print the authentication token
        System.out.println(auth.getTokenSecret()); // Print the authentication token secret
        return flickr; // Return the Flickr instance
    } */
    @Bean
    public Flickr getFlickr2() {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
        return flickr;
    }

}
