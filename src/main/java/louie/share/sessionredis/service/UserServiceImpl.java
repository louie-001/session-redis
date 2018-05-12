package louie.share.sessionredis.service;

import louie.share.sessionredis.bean.BaseResponse;
import louie.share.sessionredis.bean.User;
import louie.share.sessionredis.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author louie
 * @date created in 2018-5-12 17:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override
    public BaseResponse login(String account, String password) {
        BaseResponse response = new BaseResponse(false);
        User user = findByAccount(account);
        if (user != null){
            if (!password.equals(user.getPassword())){
                response.setMessage("invalid password");
            }else {
                response.setOk(true);
                response.setMessage("login success");
                response.setData(user);
            }
        }else {
            response.setMessage("user not exist,accnout:"+account);
        }
        return response;
    }


}
