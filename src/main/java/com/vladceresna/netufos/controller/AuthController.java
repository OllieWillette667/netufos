package com.vladceresna.netufos.controller;

import com.vladceresna.netufos.pojos.PassUser;
import com.vladceresna.netufos.pojos.User;
import com.vladceresna.support.SL;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.json.Path2;

import java.util.Set;

@Controller
public class AuthController {

    //login autocreate! Cxi-tie estas registration mappings

    @GetMapping("/registration")
    public String getRegistration(Model model){
        System.out.println("opimpovee");
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("submitPassword") String submitPassword,
                          @RequestParam("login") String login,
                          @RequestParam("name") String name) {
        JedisPooled j = new JedisPooled();
        try {
            if (j.jsonSet("passUser:" + j.keys("passUser:*").size(), Path2.of("$"),
                    SL.OtJ(new PassUser(username, new BCryptPasswordEncoder(12).encode(password), true,
                            Set.of(new SimpleGrantedAuthority("User"))))).equals("OK") &&
                    j.jsonSet("user:" + j.keys("user:*").size(), Path2.of("$"),
                            SL.OtJ(new User(name, login, username))).equals("OK")) {

                System.out.println("lkkkkk");
            } else {
                System.out.println("Data success, Registration don`t success");
            }
        }catch (Exception e){
            System.out.println("vrtbbbbbbbbbt");
        }

        System.out.println("ebwwwwwwww");
        Jedis jedis = new Jedis();
        jedis.save();
        return "login";
    }


}
