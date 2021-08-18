package com;



import com.example.jsonprocessing.enums.DataFormats;
import com.example.jsonprocessing.misc.seeders.DatabaseFeed;
import com.example.jsonprocessing.services.car.dealer.CarsService;
import com.example.jsonprocessing.services.car.dealer.CustomersService;
import com.example.jsonprocessing.services.car.dealer.SalesService;
import com.example.jsonprocessing.services.car.dealer.SupplierService;
import com.example.jsonprocessing.services.product.shop.CategoryService;
import com.example.jsonprocessing.services.product.shop.ProductService;
import com.example.jsonprocessing.services.product.shop.UserService;
import com.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;


@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MainController implements CommandLineRunner {
    private CourseService courseService;


    @Override
    @SneakyThrows
    public void run(String... args) throws Exception {

         boolean populated = false;
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        menu();
        String input = br.readLine().strip();
        try{
            while(!"".equals(input)){
                executeOption(input);
                menu();
                input = br.readLine().strip();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.printf("Something went wrong!%n%s%n",e.getMessage());
        }
        br.close();
    }

    public void menu(){
        System.out.printf("Type \"seed\" to populate the databases.%n" +
                "output location --> resources/out/*.json%n" +
                "****%n" +
                " 1.The required minimum credit%n" +
                " 2.The start and end date of the time period for which the students should have collected the requested credit (the time when the course is completed is used)%n" +
                " 3.The path to the directory where the reports will be saved%n" +
                " 4.Comma separated list of personal identifiers (PIN) of the students to be included in the report (the final reports should contain only students from this input list; if no PINs are provided, then all students with enough credit should be included)%n"

        );
    }

    public void executeOption(String option){
        switch (option){
            case "1" ->{
                var lower = new BigDecimal(500);
                var upper = new BigDecimal(1000);

                productService.getProductsInRangeToJSON(lower,upper, DataFormats.XML);
            }
            case "2" ->{
                userService.getUsersWithSoldItemsAtLeast(1,DataFormats.XML);
            }
            case "3" ->{
                categoryService.getCategoriesSummary(DataFormats.XML);
            }
            case "4" ->{
                userService.getUsersAndProducts(DataFormats.XML);
            }
            case "5" ->{
                customersService.getCustomersOrderedByBirthday_Query1(DataFormats.XML);
            }
            case "6" ->{
                carsService.findAllByMake_Query2("Toyota",DataFormats.XML);
            }
            case "7" ->{
                supplierService.getSuppliersLocalImportOnly_Query3(DataFormats.XML);
            }
            case "8" ->{
                carsService.getCarsWithPartsList_Query4(DataFormats.XML);
            }
            case "9" ->{
                customersService.getTotalSalesPerCustomer_Query5(DataFormats.XML);
            }
            case "10" ->{
                salesService.getSalesWithAppliedDiscount(DataFormats.XML);
            }
            default -> System.out.println("## U know that's invalid input right? ##");

        }
    }

}
