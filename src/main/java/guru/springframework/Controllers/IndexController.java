package guru.springframework.Controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoriesRepository;
import guru.springframework.repositories.UnitOfMeasurementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
    private CategoriesRepository categoryRepository;
    private UnitOfMeasurementRepository unitOfMeasurementRepository;

    public IndexController(CategoriesRepository categoryRepository, UnitOfMeasurementRepository unitOfMeasurementRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasurementRepository = unitOfMeasurementRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasurementRepository.findByDescription("Teaspoon");
        System.out.println("Category Id: " + categoryOptional.get().getId());
        System.out.println("Unit of Measurement Id: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}