package com.xzw.springbootthymeleaf.web;

import com.xzw.springbootthymeleaf.dao.ProductDAO;
import com.xzw.springbootthymeleaf.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String listProduct(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "listProduct";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable("id") Integer id) {
        return productDAO.getOne(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product) {
        productDAO.save(product);
        return "redirect:product";
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product) {
        productDAO.save(product);
        return "redirect:product";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable("id") Integer id) {
        productDAO.deleteById(id);
        return "delete success";
    }
}
