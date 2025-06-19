/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui;

import poly.cafe.dao.CrudController;
import poly.cafe.entity.Bill;

/**
 *
 * @author Lenovo
 */
public interface BillController extends CrudController<Bill> {

    void fillBillDetails(); // tải và hiển thị chi tiết phiếu

    void selectTimeRange(); // xử lý chọn khoảng thời gian trong cboTimeRanges

    void setBill(Bill bill); // truyền bill vào cửa sổ để hiển thị

    void open(); // Hiển thị bill

    void close(); // Xóa bill nếu ko chứa đồ uống nào

    void showDrinkJDialog(); // Hiển thị cửa sổ bổ sung đồ uống vào bill

    void removeD();

    void updateQuantity(); // Thay đổi số lượng đồ uống

    void checkout(); // Thanh toán  

    void cancel(); // Hủy bill
}
