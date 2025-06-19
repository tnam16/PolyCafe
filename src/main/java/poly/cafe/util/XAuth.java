/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.util;

import poly.cafe.entity.User;

/**
 *
 * @author Lenovo
 */
public class XAuth {

    public static User user = User.builder()
            .username("a")
            .password("1")
            .enabled(true)
            .manager(true)
            .fullname("Nguyễn Văn Tèo")
            .photo("trump.png")
            .build(); // biến user này sẽ được thay thế sau khi đăng nhập

    public static boolean isLogin() {
        return user != null;
    }

    public static boolean isManager() {
        return isLogin() && user.isManager();
    }
}
