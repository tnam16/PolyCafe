package poly.cafe.dao.impl;

import java.util.List;
import poly.cafe.dao.BillDetailDAO;
import poly.cafe.entity.BillDetail;
import poly.cafe.util.XJdbc;

import poly.cafe.util.XQuery;

public class BillDetailDAOImpl implements BillDetailDAO {

    String createSql = "INSERT INTO BillDetails ( billId, drinkId, unitPrice, discount, quantity) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE BillDetails SET billId = ?, drinkId = ?, unitPrice = ?, discount = ?, quantity = ? WHERE id = ?";
    String deleteSql = "DELETE FROM BillDetails WHERE id = ?";
    String findAllSql = "SELECT bd.*, d.name AS drinkName "
            + "FROM BillDetails bd "
            + "JOIN Drinks d ON d.Id = bd.DrinkId";
    String findByIdSql = "SELECT bd.*, d.name AS drinkName "
            + "FROM BillDetails bd "
            + "JOIN Drinks d ON d.Id = bd.DrinkId "
            + "WHERE bd.Id=?";
    String findByBillIdSql = "SELECT bd.*, d.name AS drinkName "
            + "FROM BillDetails bd "
            + "JOIN Drinks d ON d.Id = bd.DrinkId "
            + "WHERE bd.BillId = ?";
    String findByDrinkIdSql = "SELECT bd.*, d.name AS drinkName "
            + "FROM BillDetails bd "
            + "JOIN Drinks d ON d.Id  = bd.DrinkId "
            + "WHERE bd.DrinkId  =  ?";

    @Override
    public BillDetail create(BillDetail entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(BillDetail entity) {
        Object[] values = {
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity(),
            entity.getId() // WHERE id = ?
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    /* public List<BillDetail> findAll() {
        return XQuery.getEntityList(BillDetail.class, findAllSql);
    }*/
    @Override
    public BillDetail findById(Long id) {
        return XQuery.getSingleBean(BillDetail.class, findByIdSql, id);
    }

    @Override
    public List<BillDetail> findByBillId(Long billId) {
        return XQuery.getBeanList(BillDetail.class, findByBillIdSql, billId);
    }

    @Override
    public List<BillDetail> findByDrinkId(String drinkId) {
        return XQuery.getBeanList(BillDetail.class, findByDrinkIdSql, drinkId);
    }

    @Override
    public List<BillDetail> findAll() {
        return XQuery.getBeanList(BillDetail.class, findAllSql);
    }
    
}
