package com.davy.restaurant.services;

import com.davy.restaurant.models.Category;
import com.davy.restaurant.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepo cr;
    public List<Category> getAllCategories()
    {
     System.out.println("Found Categories");
        return cr.findAll();
    }

    public String AddCategory(Category category)
    {
        if(category.getId() == 0)
        {
            category.setId(cr.findAll().size()+1);
            cr.save(category);
            return "Category added successfully";
        }
        return null;
    }
}
