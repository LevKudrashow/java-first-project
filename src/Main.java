import java.util.Scanner;
// Task about 4 principles of OOP and super constructor usage.
abstract class Weapon {
    private int damage;
    public Weapon(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public abstract void attack();

}

class Axe extends Weapon {
    public Axe(int damage) {
        super(damage);
    }
    @Override
    public void attack()
    {
        System.out.println("Axe hits for "+this.getDamage());
    };
}

class Poleaxe extends Axe {
    private int range;
    public Poleaxe(int damage, int range) {
        super(damage);
        this.range = range;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
    @Override
    public void attack()
    {
        System.out.println("Poleaxe hits for "+this.getDamage() + "in range of " +this.getRange());
    };

}


// Task about shop classes
class Product
{
    private String label;
    private double price;
    public Product(String label)
    {
        this.label=label;
        CheckPrice();
    }
    public Product(String label, double price)
    {
        this.label=label;
        this.price=price;
        CheckPrice();
    }
    public double GetPrice()
    {
        return this.price;
    }
    public String GetLabel()
    {
        return this.label;
    }
    private void CheckPrice()
    {
        Scanner scanner = new Scanner(System.in);
        while (this.price<=0)
        {
            System.out.println("Item "+this.label+" is not priced or invalid pricing. Write a new price");
            this.price=scanner.nextDouble();
        }
    }
    public void Show()
    {
        System.out.print("Item label: "+this.label + ", ");
        System.out.println("price: "+this.price);
    }
}

class Shopcart
{
    Product itemsInCart[] = new Product[20];
    int lastItem=0;
    double overallPrice = 0;
    public void addProduct(Product prod)
    {
        if(lastItem<itemsInCart.length-1) {
            System.out.println("Item "+prod.GetLabel()+" has been added to cart.");
            itemsInCart[lastItem] = prod;
            lastItem++;
            overallPrice += prod.GetPrice();
        }
        else {
            System.out.println("Cart is full");
        }
    }
    public void Show()
    {
        for (int i=0;i<lastItem;i++)
        {
            itemsInCart[i].Show();
        }
        System.out.println("Overall price of the cart: "+this.overallPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        /*// Task about 4 principles of OOP and super constructor usage.

        Poleaxe W1= new Poleaxe(13,3);
        System.out.println("DMG="+W1.getDamage()+"\nRANGE="+W1.getRange());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write new DMG and RANGE:");
        W1.setDamage(scanner.nextInt());
        W1.setRange(scanner.nextInt());

        System.out.println("DMG="+W1.getDamage()+"\nRANGE="+W1.getRange());*/

        /*// Task about shop classes
        int arrSize = 5;
        Product[] items = new Product[arrSize];
        items=GetProducts("Thing",1,arrSize);
        FillProducts("Thing",1,arrSize,items);


        Shopcart cart = new Shopcart();
        cart.addProduct(items[0]);
        cart.addProduct(items[1]);
        cart.Show();*/

    }
    public static Product[] GetProducts(String label, double price, int size)
    {
        Product items[] = new Product[size];
        for (int i=0;i<size;i++)
        {
            items[i]= new Product((label+i), price+i);
            items[i].Show();
        }
        return items;
    }

    public static void FillProducts(String label, double price, int size, Product[] arr)
    {
        for (int i=0;i<size;i++)
        {
            arr[i]= new Product((label+i), price+i);
            arr[i].Show();
        }
        System.out.println();
    }
}