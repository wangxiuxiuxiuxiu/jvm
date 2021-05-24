package aop.more_aspect;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser(String id) {
        System.out.println("UserService 保存用户" + id);
    }
}
