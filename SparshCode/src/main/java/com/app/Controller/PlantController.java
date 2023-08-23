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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.AppConstants;
import com.app.DTO.PlantDto;
import com.app.DTO.PlantResponse;
import com.app.Service.PlantService;

@RestController
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	private PlantService plantService;

	@PostMapping("/create/{catid}")
	@ResponseBody
	// adding Plant
	public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plant, @PathVariable int catid) {
		PlantDto createPlant = plantService.createPlant(plant, catid);
		return new ResponseEntity<PlantDto>(createPlant, HttpStatus.CREATED);
	}

	// view All Plants
	@GetMapping("/view")
	public PlantResponse viewAllPlants(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER_STRING, required = false) int pageNumber,
			@RequestParam(value = "pazeSize", defaultValue = AppConstants.PAGE_SIZE_STRING, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_STRING, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_STRING, required = false) String sortDir) {
		PlantResponse plantRes = plantService.viewAll(pageNumber, pageSize, sortBy, sortDir);
		return plantRes;
	}

	// View Plant By Id
	@GetMapping("/view/{pid}")
	public ResponseEntity<PlantDto> viewPlantById(@PathVariable int pid) {
		PlantDto viewOne = plantService.viewById(pid);
		return new ResponseEntity<PlantDto>(viewOne, HttpStatus.FOUND);
	}

	// delete product by Id
	@DeleteMapping("/del/{pId}")
	public ResponseEntity<String> deletePlantById(@PathVariable int pId) {
		plantService.deletePlant(pId);
		return new ResponseEntity<String>("Product Deleted", HttpStatus.OK);
	}

	// update product by id
	@PutMapping("/update/{pid}")
	public ResponseEntity<PlantDto> updatePlantById(@PathVariable int pid, @RequestBody PlantDto newPlant) {
		PlantDto updatePlant = plantService.updatePlant(pid, newPlant);
		return new ResponseEntity<PlantDto>(updatePlant, HttpStatus.ACCEPTED);
	}

	// find product category wise
	@GetMapping("/cat/{catId}")
	public ResponseEntity<List<PlantDto>> getplantbyCat(@PathVariable int catId) {
	    List<PlantDto> findplantbyCatid =plantService.findPlantbyCat(catId);
		return new ResponseEntity<List<PlantDto>>(findplantbyCatid,HttpStatus.ACCEPTED);
	}
}
