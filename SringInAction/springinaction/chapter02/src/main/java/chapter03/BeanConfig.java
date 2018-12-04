package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Dessert.class)
public class BeanConfig {
    private Dessert dessert;
    @Autowired
    @Qualifier("iceCream")
    public void iceCream(Dessert dessert) {
        this.dessert = dessert;
    }

}
