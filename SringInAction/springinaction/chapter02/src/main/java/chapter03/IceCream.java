package chapter03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component//(value = "iceCream")
public class IceCream implements Dessert {
}
