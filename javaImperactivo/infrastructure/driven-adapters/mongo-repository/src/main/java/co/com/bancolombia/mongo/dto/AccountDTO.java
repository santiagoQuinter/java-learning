package co.com.bancolombia.mongo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//Le colocamos la colección de la bd
@Data
/*Builder me permite construir los objetos a traves del patrón builder, el cual sosiste en :
Normalmente yo creo y el objeto y através del constructor le paso lo atributos
La otra forma es através de setters o la otra forma es através del patrón builder
Que me permite llamar la clase y le digo los campos(accountNumber y accountType) y le digo build
y con eso me está construyendo un objeto diferente
El builder me permite colocar o poner condiciones en la creación del objeto, por ejemplo:
 si no te llena el tipo de cuenta por default puedes decir que es de ahorros*/
//Todo investigar sobre el patrón builder
@Builder(toBuilder = true)
@Document(collection = "Account")
public class AccountDTO {
    //Esta anotación permite colocarle el nombre que le di en la bd
    @Field("accountNumber")
    private int accountNumber;

    @Field("accountType")
    private int accountType;

}
