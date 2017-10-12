package com.jbhunt.sandbox.patterns.builder;

import org.junit.Assert;
import org.junit.Test;

public class BuilderTests {
    @Test
    public void builder() {
        // if you ask me, this is just a hack to get C#'s named optional parameters
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(3, 1).calories(100).sodium(34).carbs(4).build();

        Assert.assertEquals(0, nutritionFacts.getFat());
        Assert.assertEquals(100, nutritionFacts.getCalories());
    }
}
