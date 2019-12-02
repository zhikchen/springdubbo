package cn.jxufe.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = RpcService.class,version = "2.0")
@Component
public class RpcServiceImpl implements RpcService {

    @Override
    public String returnValue() {
        System.out.println("here are provider!");
        return "hello dubbo!";
    }
}
