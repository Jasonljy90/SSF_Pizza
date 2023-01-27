package sg.edu.nus.iss.app.lovecalc.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PizzaOrder {
    @NotNull(message="Pizza choice cannot be null")
    private String pizza;

    @NotNull(message="Pizza size cannot be null")
    private String size;

    @Size(min=1, max=10, message="You can only choose between 1 and 10 pizzas")
    private Integer quantity;

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    // public PizzaOrder() {
    //     this.id = generateId(8);
    // }

    
    // private synchronized String generateId(int numChars) {
    //     Random r = new Random();
    //     StringBuilder strBuilder = new StringBuilder();
    //     while (strBuilder.length() < numChars) {
    //         strBuilder.append(Integer.toHexString(r.nextInt()));
    //     }
    //     return strBuilder.toString().substring(0, numChars);
    // }

    // public static PizzaOrder create(String json) throws IOException {
    //     PizzaOrder loveResult = new PizzaOrder();
    //     try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
    //         JsonReader r = Json.createReader(is);
    //         JsonObject o = r.readObject();
    //         // remove encoding chars from API
    //         String person1Name = URLDecoder.decode(o.getString("fname"), "UTF-8");
    //         String person2Name = URLDecoder.decode(o.getString("sname"), "UTF-8");
    //         loveResult.setFname(person1Name);
    //         loveResult.setSname(person2Name);
    //         loveResult.setPercentage(Integer.parseInt(o.getString("percentage")));
    //         loveResult.setResult(o.getString("result"));
    //     }
    //     return loveResult;
    // }

}
