package uz.kucharov.apibank.payload;

import lombok.Data;
import uz.kucharov.apibank.entity.User;

@Data
public class ApplicationDto {
    private Double salary;
    private Double creditAmount;
    private Double tolovMuddati;
    private Double kreditYillikFoizi;
    private Integer userId;
}
