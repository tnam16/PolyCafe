/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
/**
 *
 * @author Lenovo
 */
@AllArgsConstructor
 @NoArgsConstructor
 @Builder
 @Data
 public class ByCategory {
 private String category;
 private double revenue;
 private int quantity;
 private double minPrice;
 private double maxPrice;
 private double avgPrice;
 }