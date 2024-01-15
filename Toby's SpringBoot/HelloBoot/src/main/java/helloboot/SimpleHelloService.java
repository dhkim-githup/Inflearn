package helloboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name){
        return "Simple say Hello "+name;
    }
}
