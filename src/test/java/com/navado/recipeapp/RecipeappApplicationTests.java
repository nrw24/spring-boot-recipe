package com.navado.recipeapp;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RecipeappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testHello() {
		assertEquals("Hello Navado", RecipeappApplication.hello());
	}

	@Test
	void testRecipeAPI() {
		String meal = "pasta";
		int maxFat = 25;
		int maxResults = 2;
		try {
			JSONObject expected = new JSONObject("{\"offset\": 0, \"number\": 2, \"results\": [{\"id\": 716429, \"title\": \"Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs\",\"image\": \"https://spoonacular.com/recipeImages/716429-312x231.jpg\",\"imageType\": \"jpg\",}, {\"id\": 715538,\"title\": \"What to make for dinner tonight?? Bruschetta Style Pork & Pasta\",\"image\": \"https://spoonacular.com/recipeImages/715538-312x231.jpg\",\"imageType\": \"jpg\",}],\"totalResults\": 86}");
			assertEquals(expected, RecipeappApplication.searchRecipes(meal));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
