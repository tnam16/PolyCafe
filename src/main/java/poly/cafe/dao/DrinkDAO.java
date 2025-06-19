package poly.cafe.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import poly.cafe.dao.CrudDAO;
import java.util.List;
import poly.cafe.entity.Drink;

/**
 *
 * @author Lenovo
 */
public interface DrinkDAO extends CrudDAO<Drink, String>{
 List<Drink> findByCategoryId(String categoryId);
}
