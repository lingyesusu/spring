package bing.server;

import javax.jws.WebService;

/**
 * <p>
 * WebService½Ó¿Ú
 * </p>
 * 
 * @author IceWee
 * @date 2012-7-6
 * @version 1.0
 */
@WebService
public interface IHelloService {

    public String sayHello(String username);
    
}