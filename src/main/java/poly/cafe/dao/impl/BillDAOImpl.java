/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao.impl;

import static com.sun.source.tree.Tree.Kind.AND;
import java.util.Date;
import java.util.List;
import static javax.swing.text.html.HTML.Tag.SELECT;
import poly.cafe.dao.BillDAO;
import poly.cafe.entity.Bill;
import poly.cafe.util.XAuth;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

/**
 *
 * @author Lenovo
 */
public class BillDAOImpl implements BillDAO {

    String createSql = "INSERT INTO Bills (username, cardId, checkin, checkout, status) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Bills SET username = ?, cardId = ?, checkin = ?, checkout = ?, status = ? WHERE id = ?";
    String deleteSql = "DELETE FROM Bills WHERE id = ?";
    String findAllSql = "SELECT * FROM Bills";
    String findByIdSql = "SELECT * FROM Bills WHERE id = ?";

    public Bill create(Bill entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCardId(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    public void update(Bill entity) {
        Object[] values = {
            entity.getUsername(),
            entity.getCardId(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus(),
            entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override

    public List<Bill> findByTimeRange(Date begin, Date end) {
        String sql = "SELECT * FROM Bills " + " WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";
        return XQuery.getBeanList(Bill.class, sql, begin, end);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Bill> findAll() {
        return XQuery.getBeanList(Bill.class, findAllSql);
    }

    @Override
    public Bill findById(Long id) {
        return XQuery.getSingleBean(Bill.class, findByIdSql, id);
    }

    @Override
    public List<Bill> findByUserAndTimeRange(String username, Date begin, Date end) {
        String sql = "SELECT * FROM Bills "
                + " WHERE Username=? AND Checkin BETWEEN ? AND ?";
        return XQuery.getBeanList(Bill.class, sql, username, begin, end);
    }

    @Override
    public Bill findServicingByCardId(Integer cardId) {
        String sql = "SELECT * FROM Bills WHERE CardId=? AND Status=0";
        Bill bill = XQuery.getSingleBean(Bill.class, sql, cardId);
        if (bill == null) { // không tìm thấy -> tạo mới
            Bill newBill = new Bill();
            newBill.setCardId(cardId);
            newBill.setCheckin(new Date());
            newBill.setStatus(0); // đang phục vụ
            newBill.setUsername(XAuth.user.getUsername());
            bill = this.create(newBill); // insert
        }
        return bill;
    }

    @Override
    public void delete(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }
}

