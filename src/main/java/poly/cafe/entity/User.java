/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.Date;
import lombok.Data;
/**
 *
 * @author Lenovo
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    private String username;
 private String password;
 private boolean enabled;
 private String fullname;
 @Builder.Default
 private String photo = "trump-small.png";
 private boolean manager;
}
