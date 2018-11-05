package com.gabchak.controller;

import com.gabchak.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(path = "/{categoryName}/product_{productId}", method = RequestMethod.GET)
    public ModelAndView showProductPage2(@PathVariable String categoryName, @PathVariable Long productId, ModelAndView vm) {

        vm.setViewName("product");
        vm.addObject("product", productDao.findById(productId));

        return vm;
    }

    //TODO: admin: edit product page
    //TODO: admin: add product page
    //TODO: admin: remove product (POST)
}
