package cn.shine365.demo.day03.webflux;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author taobaibai
 * @create 2020-04-04 20:58
 */
public class WebClientTest {
    @Test
    public void testBase(){
        Mono<String> bodyMono = WebClient.create().get()
                                                    .uri("http://localhost:8899/api/v1/user/find?id=1")
                                                    .accept(MediaType.APPLICATION_JSON)
                                                    .retrieve().bodyToMono(String.class);
        System.out.println(bodyMono.block());
    }

    @Test
    public void testBase2(){
        Mono<String> bodyMono = WebClient.create().get()
                                                    .uri("http://localhost:8899/api/v1/user/find?id={id}",2)
                                                    .accept(MediaType.APPLICATION_JSON)
                                                    .retrieve().bodyToMono(String.class);
        System.out.println(bodyMono.block());
    }

    @Test
    public void testBase3(){
        Flux<String> bodyMono = WebClient.create().get()
                .uri("http://localhost:8899/api/v1/user/list")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve().bodyToFlux(String.class);
        System.out.println(bodyMono.collectList().block());
    }
}
