package com.navado.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RecipeappApplication {

	private static final int MAX_RECIPES_PER_SEARCH = 2;

	public static void main(String[] args) {
		SpringApplication.run(RecipeappApplication.class, args);
	}

	@RequestMapping("/")
	public static String hello(){
		return "Hello Navado";
	}

	@GetMapping("/search/recipe/{recipe}")
	public static Object searchRecipes(@PathVariable String recipe){
		System.out.println(recipe);
		RestTemplate client = new RestTemplate();
		String url = String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=7dabb2c9d04348bd9d511e6045a210d2&query=%s&maxFat=%d&number=%d", recipe,25, MAX_RECIPES_PER_SEARCH);
		Object recipes = client.getForObject(url, Object.class);
		System.out.println(recipes);
		return recipes;
	}
}
