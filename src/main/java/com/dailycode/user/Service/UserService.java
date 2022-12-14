package com.dailycode.user.Service;

import com.dailycode.user.Entity.User;
import com.dailycode.user.Repository.UserRepository;
import com.dailycode.user.VO.Department;
import com.dailycode.user.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("Inside the saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside the getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                        Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
