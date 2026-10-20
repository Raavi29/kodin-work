class Product
{    
    String name;    
    double price;    
    int quantity;    
    double total;    
    Product(String name, double price, int quantity)    
    {        
        this.name = name;        
        this.price = price;        
        this.quantity = quantity;        
        this.total = price * quantity;      
    }
}
public class code9
{    
    public static void main(String[] args)    
    {        
        Product[] cart = {            
            new Product("Notebook", 45.50, 4),            
            new Product("Pen Box", 120.00, 2),            
            new Product("Backpack", 899.99, 1)        
        };        
        double bill = 0;        
        int totalItems = 0;        
        System.out.println("Item          Price   Qty      Total");        
        for (Product p : cart)        
        {            
            System.out.printf("%-10s %8.2f %5d %10.2f%n", p.name, p.price, p.quantity, p.total);            
            bill = bill + p.total;            
            totalItems = totalItems + p.quantity;        
        }        
        System.out.printf("Bill before discount : %.2f%n", bill);        
        int discountPercent = 10;        
        double discount = bill * discountPercent / 100;             
        double finalBill = bill - discount;        
        System.out.printf("Discount (%d%%)       : %.2f%n", discountPercent, discount);        
        System.out.printf("Final bill           : %.2f%n", finalBill);        
        long itemsAsLong = totalItems;          
        float itemsAsFloat = totalItems;        
        System.out.println("\nImplicit casting");        
        System.out.println("int " + totalItems + " -> long " + itemsAsLong + " -> float " + itemsAsFloat);        
        int truncatedBill = (int) finalBill;                    
        int roundedBill = (int) Math.round(finalBill);          
        float floatBill = (float) finalBill;                    
        System.out.println("\nExplicit casting");        
        System.out.println("(int) finalBill             = " + truncatedBill);        
        System.out.println("(int) Math.round(finalBill) = " + roundedBill);        
        System.out.println("(float) finalBill           = " + floatBill);    
    }
}