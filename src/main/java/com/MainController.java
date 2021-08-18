package com;



import com.service.CourseService;
import com.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;


@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MainController implements CommandLineRunner {
    private CourseService courseService;
    private ReportService reportService;


    @Override
    @SneakyThrows
    public void run(String... args) throws Exception {


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
        System.out.printf(
                "****%n" +
                " 1.The required minimum credit%n" +
                " 2.The start and end date of the time period for which the students should have collected the requested credit (the time when the course is completed is used)%n" +
                " 3.The path to the directory where the reports will be saved%n" +
                " 4.Comma separated list of personal identifiers (PIN) of the students to be included in the report (the final reports should contain only students from this input list; if no PINs are provided, then all students with enough credit should be included)%n"

        );
    }

    public void executeOption(String option){
        Scanner scanner = new Scanner(System.in);
        switch (option){
            case "1":{


            }
            case "2":{

            }
            case "3": {
                String path = scanner.nextLine();
                this.reportService.report(path);
            }
            default: System.out.println("## U know that's invalid input right? ##");

        }
    }

}
