/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui;

import poly.cafe.dao.CrudController;
import poly.cafe.entity.Bill;
import poly.cafe.entity.Drink;

/**
 *
 * @author Lenovo
 */
public interface DrinkController extends CrudController<Drink> {

    void fillCategories();

    void chooseFile();

    void setBill(Bill bill); // nhận bill từ BillJDialog

    void open(); // hiển thị loại và đồ uống

    void fillDrinks(); // tải và hiển thị đồ uống

    void addDrinkToBill(); // thêm đồ uống vào
}
