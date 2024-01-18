package com.main.expenseapp.controllers;

import com.main.expenseapp.dto.request.ExpenseRequestDto;
import com.main.expenseapp.dto.response.ExpenseResponseDto;
import com.main.expenseapp.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto){

        String response = expenseService.createExpense(expenseRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseResponseDto>> getExpenses() {
        List<ExpenseResponseDto> responses = expenseService.getAllExpenses();
        System.out.println("ExpenseController: obteniendo todos los gastos");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responses);
    }
}
