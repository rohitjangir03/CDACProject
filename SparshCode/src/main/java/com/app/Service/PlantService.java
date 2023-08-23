package com.app.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.CustomException.customException;
import com.app.DTO.CategoryDto;
import com.app.DTO.PlantDto;
import com.app.DTO.PlantResponse;
import com.app.Model.Category;
import com.app.Model.Plant;
import com.app.Repository.CategoryRepository;
import com.app.Repository.PlantRepository;

@Service
public class PlantService {
   @Autowired
   private PlantRepository plantRepo;
   @Autowired
   private CategoryRepository catRepo;
   
   //add plant Service
   public PlantDto createPlant(PlantDto plant , int catid) {
	 //Fetch Category available or not
	    Category cat = catRepo.findById(catid).orElseThrow(()-> new customException(catid+" from list is not Found"));
	   //PlantDto to Plant
	   Plant entity = toEntity(plant);
	   entity.setCategory(cat);
	  Plant save =  plantRepo.save(entity);
	  //Plant to PlantDto
	  PlantDto dto = toDto(save);
	   return dto;
   }
   
   //View all Plants Service
   public PlantResponse viewAll(int pageNumber,int pageSize,String sortBy,String sortDir){
	   Sort sort=null;
	   if(sortDir.trim().toLowerCase().equals("asc")) {
		   sort = Sort.by(sortBy).ascending();
	   }
	   else {
		   sort= Sort.by(sortBy).descending();
	   }
	  Pageable pageable =  PageRequest.of(pageNumber, pageSize,sort);
	  Page<Plant> page =  this.plantRepo.findAll(pageable);
	  List<Plant> pagePlant = page.getContent();
	  //List<Plant> plant = pagePlant.stream().filter(p -> p.isStock()).collect(Collectors.toList());
	  List<PlantDto> plantDto = pagePlant.stream().map(p->this.toDto(p)).collect(Collectors.toList());
	  
	  PlantResponse plantRes = new PlantResponse();
	  plantRes.setContent(plantDto);
	  plantRes.setPageNumber(page.getNumber());
	  plantRes.setPageSize(page.getSize());
	  plantRes.setTotalPage(page.getTotalPages());
	  plantRes.setLastPage(page.isLast());
	//  List<Plant> findAll= plantRepo.findAll();
	//  List<PlantDto> plist= findAll.stream().map(p -> this.toDto(p)).collect(Collectors.toList());
	   return plantRes;
   }
   
   //view Plant by Id Service
   public PlantDto viewById(int pId) {
	   Plant findById = plantRepo.findById(pId).orElseThrow(()-> new customException(pId+" from list is not Found"));
	   PlantDto dto = this.toDto(findById);
	   return dto;
   }
   
   //delete by Id Service
   public void deletePlant(int pid) {
	   plantRepo.findById(pid).orElseThrow(()-> new customException(pid+" from list is not Found"));
	   plantRepo.deleteById(pid);
   }
   
   //update product by Id
   public PlantDto updatePlant(int pId , PlantDto newPlant) {
	   Plant oldPlant = plantRepo.findById(pId).orElseThrow(()-> new customException(pId+" from list is not Found"));
	   oldPlant.setImg(newPlant.getImg());
	   oldPlant.setDescription(newPlant.getDescription());
	   oldPlant.setPlantName(newPlant.getPlantName());
	   oldPlant.setPrice(newPlant.getPrice());
	   oldPlant.setQuantity(newPlant.getQuantity());
	   Plant save = plantRepo.save(oldPlant);
	   PlantDto dto = this.toDto(save);
	   return dto;
   }
   
   //PlantDto to Plant
   public Plant toEntity(PlantDto pDto) {
	   Plant p = new Plant();
	   p.setPlantId(pDto.getPlantId());
	   p.setPlantName(pDto.getPlantName());
	   p.setDescription(pDto.getDescription());
	   p.setImg(pDto.getImg());
	   p.setPrice(pDto.getPrice());
	   p.setQuantity(pDto.getQuantity());
	   return p;
   }
   //Plant to PlantDto
   public PlantDto toDto(Plant p) {
	   PlantDto pDto = new PlantDto();
	   pDto.setPlantId(p.getPlantId());
	   pDto.setPlantName(p.getPlantName());
	   pDto.setDescription(p.getDescription());
	   pDto.setImg(p.getImg());
	   pDto.setPrice(p.getPrice());
	   pDto.setQuantity(p.getQuantity());
	   
	   //change category to categorryDto
	   CategoryDto catDto = new CategoryDto();
	   catDto.setCatId(p.getCategory().getCatId());
	   catDto.setCatName(p.getCategory().getCatName());
	   
	   //Then set CategoryDto in ProducDto
	   pDto.setCategoryDto(catDto);
	   return pDto;
   }
   
   //find plant by category
   
   public List<PlantDto> findPlantbyCat(int catId){
	   Category cat = catRepo.findById(catId).orElseThrow(()-> new customException(catId+" from list is not Found"));
	   List<Plant> findByCat = plantRepo.findByCategory(cat);
	   List<PlantDto> collect = findByCat.stream().map(p -> toDto(p)).collect(Collectors.toList());
	   return collect;
   }
}
