package com.argent.health.app.web.rest.request.food;

import com.argent.health.app.enums.MealType;
import com.argent.health.app.util.Const;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Valid
public class FoodUpdateRequest {
    @Size(max = Const.USERNAME.USERNAME_MAX_LENGTH, min = Const.USERNAME.USERNAME_MIN_LENGTH, message = "LENGTH_USERNAME")
    @NotBlank(message = "FOOD_NAME_REQUIRED")
    private String foodName;
    private LocalDateTime eatAt;
    private MealType mealType;
    private Integer calorie;
}
