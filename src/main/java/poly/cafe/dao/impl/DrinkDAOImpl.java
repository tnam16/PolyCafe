package poly.cafe.impl;

import java.util.List;
import poly.cafe.dao.DrinkDAO;
import poly.cafe.entity.Drink;
import poly.cafe.util.XJdbc;

import poly.cafe.util.XQuery;

public class DrinkDAOImpl implements DrinkDAO {

    String createSql = "INSERT INTO Drinks(Id, Name, Image, UnitPrice, Discount, Available, CategoryId) VALUES(?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Drinks SET Name = ?, Image = ?, UnitPrice = ?, Discount = ?, Available = ?, CategoryId = ? WHERE Id = ?";
    String deleteSql = "DELETE FROM Drinks WHERE Id=?";
    String findAllSql = "SELECT * FROM Drinks";
    String findByIdSql = "SELECT * FROM Drinks WHERE Id=?";
    String findByCategoryId = "SELECT * FROM Drinks WHERE CategoryId = ?";

    @Override
    public Drink create(Drink entity) {
        Object[] values = {
            entity.getId(),
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Drink entity) {
        Object[] values = {
            entity.getName(),
            entity.getImage(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.isAvailable(),
            entity.getCategoryId(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
//    XJdbc.executeUpdate(deleteSql, id);
        String deleteBillDetailsSql = "DELETE FROM BillDetails WHERE DrinkId = ?";
        XJdbc.executeUpdate(deleteBillDetailsSql, id); // Xóa ở bảng phụ trước
        XJdbc.executeUpdate(deleteSql, id);            // Sau đó mới xóa ở bảng Drinks
    }

    @Override
    /*public List<Drink> findAll() {
        return XQuery.getEntityList(Drink.class, findAllSql);
    }*/

    public Drink findById(String id) {
        return XQuery.getSingleBean(Drink.class, findByIdSql, id);
    }

    String findByCategoryIdSql = "SELECT * FROM Drinks WHERE CategoryId=?";

    @Override
    public List<Drink> findAll() {
        return XQuery.getBeanList(Drink.class, findAllSql);
    }

    @Override
    public List<Drink> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Drink.class, findByCategoryId, categoryId);
    }
}
