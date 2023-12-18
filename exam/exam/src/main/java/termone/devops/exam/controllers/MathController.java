package termone.devops.exam.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import termone.devops.exam.dtos.DoMathRequestDto;
import termone.devops.exam.exceptions.InvalidOperationException;
import termone.devops.exam.payload.ApiResponse;

@RestController
@RequestMapping("/api/v1/do_math")
public class MathController {
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }

}
