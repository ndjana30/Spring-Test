package com.davy.restaurant.controllers;

import com.davy.restaurant.models.Category;
import com.davy.restaurant.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins = {"http://localhost:8081/",
        "http://10.0.2.2:8081/","http://127.0.0.1:8081/","http://192.168.1.113:5555/"})
public class CategoryController {
    @Autowired
    private CategoryServices cs;

    @GetMapping("all")
    public List<Category> getCategories()
    {
        return cs.getAllCategories();
    }
    @PostMapping("add")
    public String addCategory(@RequestBody Category category,@RequestParam("image") MultipartFile File)  throws IOException, SQLException {
        Blob blob = new SerialBlob(File.getBytes());
        category.setImage(blob);

        return cs.AddCategory(category);
    }
}
