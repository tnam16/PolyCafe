package poly.cafe.dao.impl;

import java.util.List;
import poly.cafe.dao.UserDAO;
import poly.cafe.entity.User;
import poly.cafe.util.XJdbc;

import poly.cafe.util.XQuery;

public class UserDAOImpl implements UserDAO {

    String createSql = "INSERT INTO Users (username, password, enabled, fullname, photo, manager) VALUES (?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Users SET password = ?, enabled = ?, fullname = ?, photo = ?, manager = ? WHERE username = ?";
    String deleteSql = "DELETE FROM Users WHERE username = ?";
    String findAllSql = "SELECT * FROM Users";
    String findByIdSql = "SELECT * FROM Users WHERE username = ?";

    @Override
    public User create(User entity) {
//        Object[] values = {
//            entity.getUsername(),
//            entity.getPassword(),
//            entity.isEnabled(),
//            entity.getFullname(),
//            entity.getPhoto(),
//            entity.isManager()
//        };
//        XJdbc.executeUpdate(createSql, values);
//        return entity;
        String photo = entity.getPhoto();
        if (photo == null || photo.trim().isEmpty()) {
            photo = "default.png"; // tên ảnh mặc định bạn có trong thư mục ảnh
        }

        Object[] values = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            photo,
            entity.isManager()
        };

        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.getPhoto(),
            entity.isManager(),
            entity.getUsername() // WHERE username = ?
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    /* public List<User> findAll() {
        return XQuery.getEntityList(User.class, findAllSql);
    }*/

    public User findById(String id) {
        return XQuery.getSingleBean(User.class, findByIdSql, id);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }
}
