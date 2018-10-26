package br.com.stelo.vendedor.cadastro.models.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BroadValidator.class)
public @interface BroadFields {
	
    String message() default "{br.com.stelo.vendedor-altcad.broad.message}";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    String checkclass();
}
