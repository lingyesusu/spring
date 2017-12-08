package bing.server;

import javax.jws.WebService;

/**
 * <p>
 * WebService µœ÷¿‡
 * </p>
 * 
 * @author IceWee
 * @date 2012-7-6
 * @version 1.0
 */
@WebService(endpointInterface = "bing.server.IHelloService", serviceName = "HelloService")
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String username) {
        return "hello, " + username;
    }

}