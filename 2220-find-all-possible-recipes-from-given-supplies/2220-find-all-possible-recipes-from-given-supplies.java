import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        HashSet<String> available = new HashSet<>(Arrays.asList(supplies));
        boolean addedNewRecipe = true;

        while (addedNewRecipe) { // Repeat until no new recipe can be added
            addedNewRecipe = false;
            for (int i = 0; i < recipes.length; i++) {
                if (available.contains(recipes[i])) continue; // Skip if already available
                boolean canMake = true;

                for (String ing : ingredients.get(i)) {
                    if (!available.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    ans.add(recipes[i]);
                    available.add(recipes[i]); // Add to available ingredients
                    addedNewRecipe = true; // Indicate progress
                }
            }
        }
        return ans;
    }
}
