package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    String userDemo_api = "userDemo-8001";

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        // 调用userDemo服务的/user/{id}接口
        //String user = restTemplate.getForObject("http://"+userDemo_api+"/user/" + id, String.class);
        String user = restTemplate.getForObject("http://userDemo/user/" + id, String.class);
        return "Order id: " + id + ", User: " + user;
    }

    @GetMapping("/dicovery")
    public Object discovery() {
        List<String> serviceList=discoveryClient.getServices();
        List<ServiceInstance> instanceList=discoveryClient.getInstances("application");

        if(instanceList!=null && instanceList.size()>0){
            for(ServiceInstance instance:instanceList){
                System.out.println(instance.getHost());
                System.out.println(instance.getPort());
                System.out.println(instance.getUri());
                System.out.println(instance.getServiceId());
            }
        }
        return instanceList;
    }
}
