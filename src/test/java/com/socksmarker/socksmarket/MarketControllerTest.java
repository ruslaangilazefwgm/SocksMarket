package com.socksmarker.socksmarket;

import com.socksmarker.socksmarket.controller.MarketController;
import com.socksmarker.socksmarket.model.Sock;
import com.socksmarker.socksmarket.repository.MarketRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarketControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MarketController marketController;
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void preSet() {
        Sock sock = new Sock("red", 80, 10);
    }

    @AfterEach
    public void postSet() {
        marketRepository.deleteAll();
    }

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(marketController).isNotNull();
    }

    @Test
    public void addSocksTest() {
        Sock sock2 = new Sock("red", 50, 10);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/socks/income", sock2, String.class))
                .isNotNull();
    }

    @Test
    public void deleteSocksTest() {
        this.restTemplate.delete("http://localhost:" + port + "/api/socks/income");
    }

    @Test
    public void getSockMoreThanTest() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/socks" + "?color=red&operation=moreThan&cottonPart=70", String.class))
                .isNotNull();
    }

    @Test
    public void getSockLessThanTest() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/socks" + "?color=red&operation=lessThan&cottonPart=90", String.class))
                .isNotNull();
    }

    @Test
    public void getSockEqualsTest() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/socks" + "?color=red&operation=equals&cottonPart=80", String.class))
                .isNotNull();
    }
}
