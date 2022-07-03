package by.han.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class CalculatorController {

    @GetMapping("/calculator")
    public String getResult(HttpServletRequest request, Model model) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String action = request.getParameter("action");
        double result = operation(a, b, action);
        model.addAttribute("result", "Result: " + result);
        return "calculator/calculator";
    }

    public double operation(int a, int b, String action) {
        double result = 0;
        switch (action) {
            case "multiplication" -> result = a * b;
            case "addition" -> result = a + b;
            case "subtraction" -> result = a - b;
            case "division" -> result = a / b;
        }
        return result;
    }
}
