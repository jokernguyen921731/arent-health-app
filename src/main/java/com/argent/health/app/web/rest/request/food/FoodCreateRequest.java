package com.argent.health.app.web.rest.request.food;

import com.argent.health.app.enums.IdentityType;
import com.argent.health.app.enums.MealType;
import com.argent.health.app.enums.Role;
import com.argent.health.app.util.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsm.vin.common.model.iam.enums.ObjectStatus;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Valid
public class FoodCreateRequest {
    @Size(max = Const.USERNAME.USERNAME_MAX_LENGTH, min = Const.USERNAME.USERNAME_MIN_LENGTH, message = "LENGTH_USERNAME")
    @NotBlank(message = "FOOD_NAME_REQUIRED")
    private String foodName;
    private LocalDateTime eatAt;
    private MealType mealType;
    private Integer calorie;
}
