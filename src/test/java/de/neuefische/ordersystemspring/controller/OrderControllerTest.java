package de.neuefische.ordersystemspring.controller;

import de.neuefische.ordersystemspring.db.OrderDb;
import de.neuefische.ordersystemspring.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private OrderDb orderDb;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void resetDatabase() {
        orderDb.clearDb();
    }

    @Test
    public void listOrdersShouldReturnEmptyOrderArray() {
        //GIVEN

        //WHEN
        ResponseEntity<Order[]> response = restTemplate.getForEntity("http://localhost:" + port + "/orders", Order[].class);
        HttpStatus statusCode = response.getStatusCode();
        Order[] orders = response.getBody();

        //THEN
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(0, orders.length);
    }

    @Test
    public void putOrderShouldAddOrderToDatabase() {
        //GIVEN
        List<String> myNewOrder = List.of("1","2");
        HttpEntity <List <String>> requestEntity = new HttpEntity<>(myNewOrder);


        //WHEN

        //Das erste "Order": was erwarten wir? Siehe OrderController class
        ResponseEntity<Order> postResponse = restTemplate.exchange("http://localhost:" + port + "/orders", HttpMethod.PUT, requestEntity, Order.class);

        //THEN
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        //
        Order order= postResponse.getBody();

        // wird eine OrderID generiert?
        assertNotNull(order.getOrderId());

        assertEquals(2,order.getProducts().size());

    }

    @Test

    public void listOrdersShouldReturnAllOrders() {

        //POST
        ArrayList<String> myTestOrder = new ArrayList<>();
        ResponseEntity<Order> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/orders", myTestOrder, Order.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());


        //WHEN
        ResponseEntity<Order[]> response = restTemplate.getForEntity("http://localhost:" + port + "/orders", Order[].class);
        HttpStatus statusCode = response.getStatusCode();
        Order[] orders = response.getBody();

        //THEN

        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(1, orders.length);
        assertEquals(myTestOrder, orders[0]);

    }

}