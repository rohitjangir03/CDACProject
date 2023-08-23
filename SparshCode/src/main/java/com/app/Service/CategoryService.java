package com.app.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CustomException.customException;
import com.app.DTO.CategoryDto;
import com.app.Model.Category;
import com.app.Repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
	private CategoryRepository catRepo;
    @Autowired
    private ModelMapper mapper;
    
    
	public CategoryDto create(CategoryDto dto) {
		//CategoryDto to Category
		Category cat = mapper.map(dto, Category.class);
		Category save = catRepo.save(cat);
		return mapper.map(save, CategoryDto.class);
	}

	public CategoryDto update(CategoryDto dto , int catid) {
		Category oldcat= catRepo.findById(catid).orElseThrow(()-> new customException(catid+" from Category is not Found"));
		oldcat.setCatName(dto.getCatName());
		return this.mapper.map(oldcat, CategoryDto.class);
	}

	public void delete(int catid) {
		Category cat= catRepo.findById(catid).orElseThrow(()-> new customException(catid+" from Category is not Found"));
		catRepo.delete(cat);
	}

	public CategoryDto getbyId(int catid) {
		Category cat= catRepo.findById(catid).orElseThrow(()-> new customException(catid+" from Category is not Found"));
		return mapper.map(cat, CategoryDto.class);
	}

	public List<CategoryDto> getAll() {
		List<Category> cat= catRepo.findAll();
		List<CategoryDto> all = cat.stream().map(cat1 -> mapper.map(cat1,CategoryDto.class)).collect(Collectors.toList());
		return all;
	}
}
