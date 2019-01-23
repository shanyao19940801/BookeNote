
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

## 7.4 控制器通知

上面说到@ExceptionHandle可以处理一个处理器的所有异常，但是其他控制器呢？要么每个控制中都写一个注解要么写一个基础控制器，其他控制器继承以避免重复。这里可以用**控制器通知**<br>

控制器通知是任意带有**@ControllerAdvice**注解的类，这个类会包含一个或多个如下注解的方法：

1. @ExceptionHandle
1. @InitBinder
1. @ModelAttribute

这些方法会应用所有带有@RequestMapping注解的方法

上面异常处理方法就可以统一写在控制器通知里了

	@ControllerAdvice
	public class ArithmeticExceptionHandle {
	    @ExceptionHandler(ArithmeticException.class)
	    public String handleArithmeticException() {
	        return "exceptionhandle";
	    }
	}
