package com.emanagement.stock.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ItemRequestDto {

    @NotEmpty
    @NotBlank
    private String name;

    @Min(0)
    private Integer stock;

}
