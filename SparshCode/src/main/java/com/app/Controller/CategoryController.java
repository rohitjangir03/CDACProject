package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ApiResponse;
import com.app.DTO.CategoryDto;
import com.app.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
     @Autowired
     private CategoryService catService;
     
     //add category
     @PostMapping("/create")
     public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto catDto){
    	 CategoryDto create = catService.create(catDto);
    	 return new ResponseEntity<CategoryDto>(create,HttpStatus.ACCEPTED);
     }
     
   //update category
     @PutMapping("/update/{catid}")
     public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto catDto, @PathVariable int catid){
    	 CategoryDto update = catService.update(catDto, catid);
    	 return new ResponseEntity<CategoryDto> (update, HttpStatus.OK);
     }
     
   //delete category
     @DeleteMapping("/delete/{catid}")
     public ResponseEntity<ApiResponse> delete(@PathVariable int catId){
    	 catService.delete(catId);
    	 return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted",true), HttpStatus.OK);
     }
     
   //get category by ID
     @GetMapping("view/{catid}")
     public ResponseEntity<CategoryDto> getById(@PathVariable int catid){
    	 CategoryDto getId= catService.getbyId(catid);
    	 return new ResponseEntity<CategoryDto>(getId,HttpStatus.FOUND);
     }
     
     //get All categories
     @GetMapping("/view")
     public ResponseEntity<List<CategoryDto>> getAll(){
    	 List<CategoryDto> getAll = catService.getAll();
    	 return new ResponseEntity<List<CategoryDto>>(getAll,HttpStatus.FOUND);
     }
}
