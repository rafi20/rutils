package com.rtest.rutils.httpclient;

import static java.net.http.HttpRequest.newBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Logger;
public final class HttpClientApp {
    private static Logger logger = Logger.getLogger(HttpClientApp.class.getName());
    private static HttpClient client = HttpClient.newHttpClient();
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/nifi-api/flow/about";
        String dev_url1 = "https://devnode.dev.mycompany.com:9003/nifi-api/flow/about";
		String dev_url = "https://devnode.dev.mycompany.com:9003/nifi-api/system-diagnostics";
        String postname_url = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
        httpGetRequest(dev_url);
    }
    static void httpGetRequest(String url) throws URISyntaxException, IOException, InterruptedException {
        URI httpURI = new URI(url);
        HttpRequest request = newBuilder(httpURI).GET()
                .headers("Accept-Enconding", "gzip, deflate").build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String responseBody = response.body();
        int statusCode = response.statusCode();
        System.out.println(responseBody + ", " + statusCode);
    }
}

/*
#Client usage examples:
# TLSv1.2
java -Djdk.tls.client.protocols=TLSv1.2 -Djavax.net.debug=all -Djavax.net.ssl.keyStore=/nas_k8s_data/dev/conf/clientcerts/externalKeystore.jks -Djavax.net.ssl.keyStorePassword=e2myAppNifi@P -Djavax.net.ssl.trustStore=/nas_k8s_data/dev/conf/clientcerts/externalTruststore.jks -Djavax.net.ssl.trustStorePassword=e2myAppNifi@P HttpClientApp

# TLSv1.2, use p12 file instead of jks
java -Djdk.tls.client.protocols=TLSv1.2 -Djavax.net.debug=all -Djavax.net.ssl.keyStore=/nas_k8s_data/dev/conf/clientcerts/cdmqa-myAppnifi-admin.p12 -Djavax.net.ssl.keyStorePassword=e2myAppNifi@P -Djavax.net.ssl.trustStore=/nas_k8s_data/dev/conf/clientcerts/externalTruststore.jks -Djavax.net.ssl.trustStorePassword=e2myAppNifi@P HttpClientApp

#TLSv1.3 (default)
java -Djavax.net.debug=all -Djavax.net.ssl.keyStore=/nas_k8s_data/dev/conf/clientcerts/externalKeystore.jks -Djavax.net.ssl.keyStorePassword=e2myAppNifi@P -Djavax.net.ssl.trustStore=/nas_k8s_data/dev/conf/clientcerts/externalTruststore.jks -Djavax.net.ssl.trustStorePassword=e2myAppNifi@P HttpClientApp

# TLSv1.3, use p12 file instead of jks
java -Djavax.net.debug=all -Djavax.net.ssl.keyStore=/nas_k8s_data/dev/conf/clientcerts/nas_k8s_data/dev/conf/clientcertscert/cdmqa-myAppnifi-admin.p12 -Djavax.net.ssl.keyStorePassword=e2myAppNifi@P -Djavax.net.ssl.trustStore=/nas_k8s_data/dev/conf/clientcerts/externalTruststore.jks -Djavax.net.ssl.trustStorePassword=e2myAppNifi@P HttpClientApp

#Error: without truststore with (ca.crt) client certificate wont be presented to server
java -Djavax.net.debug=all -Djavax.net.ssl.keyStore=/nas_k8s_data/dev/conf/clientcerts/nas_k8s_data/dev/conf/clientcertscert/cdmqa-myAppnifi-admin.p12 -Djavax.net.ssl.keyStorePassword=e2myAppNifi@P -Djavax.net.ssl.trustStore=/nas_k8s_data/dev/conf/clientcerts/externalTruststore.jks -Djavax.net.ssl.trustStorePassword=e2myAppNifi@P HttpClientApp


*/