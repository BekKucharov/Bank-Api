package uz.kucharov.apibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.kucharov.apibank.entity.Application;
import uz.kucharov.apibank.entity.User;
import uz.kucharov.apibank.payload.ApiResponse;
import uz.kucharov.apibank.payload.ApplicationDto;
import uz.kucharov.apibank.repository.ApplicationRepository;
import uz.kucharov.apibank.repository.UserRepository;

import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    UserRepository userRepository;

    public ApiResponse checkApplicationStatus(Integer id){
        Optional<Application> byId = applicationRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Application not found", false);
        String result = byId.get().getResult();
        return new ApiResponse("Status of your application", true, result);
    }

    public ApiResponse addApplication(ApplicationDto applicationDto){
        Optional<User> user = userRepository.findById(applicationDto.getUserId());
        if (!user.isPresent()) return new ApiResponse("User not found!", false);

        Application application = new Application();
        application.setUser(user.get());
        application.setSalary(applicationDto.getSalary());
        application.setCreditAmount(applicationDto.getCreditAmount());
        application.setTolovMuddati(applicationDto.getTolovMuddati());
        application.setKreditYillikFoizi(applicationDto.getKreditYillikFoizi());

        boolean result = result(applicationDto.getCreditAmount(), applicationDto.getSalary(),
                applicationDto.getKreditYillikFoizi(), applicationDto.getTolovMuddati());

        if (result){
            application.setResult("Sizga bu kretid togri keladi");
        }else {
            application.setResult("Siz bu kreditni ololmaysiz");
        }

        applicationRepository.save(application);
        return new ApiResponse("Application saved. Please check result", true);
    }

    public boolean result(Double amount, Double salary, Double foizi, Double tolovMuddati){
        double yillikDaromad = (salary - (salary * 0.30)) * 12;
        double kreditningUmimiyFoizi = (amount * (foizi / 100)) * tolovMuddati;
        double umumiyTolov = kreditningUmimiyFoizi + amount;

        double result = (yillikDaromad*tolovMuddati)-umumiyTolov;
        if (result < 0) return false;

        return true;
    }
}
