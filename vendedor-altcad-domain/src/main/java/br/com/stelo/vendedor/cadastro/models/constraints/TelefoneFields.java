package br.com.stelo.vendedor.cadastro.models.constraints;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TelefoneValidator.class})
public @interface TelefoneFields {

    String message() default "{br.com.stelo.vendedor-altcad.telefones.message}";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    String firstPhone();
    String secondPhone();
}
