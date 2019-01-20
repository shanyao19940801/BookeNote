
### 7.3.2 异常处理方法

* 注解**@ExceptionHandler**

在一个Controller写一个统一的异常处理方法，可以处理该控制中所有异常

	@Controller
	@RequestMapping("/spittle/")
	public class Spittler {
	
	    @PostMapping("execption_test")
	    public String saveSpittle() {
	        int i = 2;
	        float b = 1.0f;
	        b = i/0;
	        return "yes";
	    }
	
	    @ExceptionHandler(ArithmeticException.class)
	    public String handleArithmeticException() {
	        return "exceptionhandle";
	    }
	}
