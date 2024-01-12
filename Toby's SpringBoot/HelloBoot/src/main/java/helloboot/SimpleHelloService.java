package helloboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name){
        return "Simple say Hello "+name;
    }
}
