package com.gonzalez.jesus.practica4_thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.android.synthetic.main.productos_view.view.*

class ProductoActivity : AppCompatActivity() {
    var coldDrinks =  ArrayList<Product>()
    var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()

    var opcion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val bundle = intent.extras

        if(bundle != null){
            val type = bundle.getString("type")

            when(type){
                "coldDrinks"->{
                    agregarProductos(1)
                }
                "hotDrinks"->{
                    agregarProductos(2)
                }

                "sweets"->{
                    agregarProductos(3)
                }
                "salties"->{
                    agregarProductos(4)
                }
            }
        }
        agregarProductos(opcion)

        var adaptador: AdaptadorProductos = AdaptadorProductos(this,coldDrinks)
        list_products.adapter = adaptador
    }

    fun agregarProductos(opcion: Int){
        when(opcion) {
            1 -> {
                img_title_products.setImageResource(R.drawable.cold_drinks)
                coldDrinks.clear()
                coldDrinks.add(Product("Caramel Frap", R.drawable.caramel_frap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
                coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolate_frap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6))
                coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
                coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
                coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
                coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))
            }
            2 -> {
                img_title_products.setImageResource(R.drawable.hot_drinks)
                coldDrinks.clear()
                hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6))
                hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5))
                hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4))
                hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6))
                hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7))
                hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2))
                coldDrinks = hotDrinks
            }
            3 -> {
                img_title_products.setImageResource(R.drawable.sweets)
                coldDrinks.clear()
                sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6))
                sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3))
                sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4))
                sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6))
                sweets.add(Product("Cherry cheesecake", R.drawable.strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7))
                sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6))
                coldDrinks = sweets
            }
            4 -> {
                img_title_products.setImageResource(R.drawable.salties)
                coldDrinks.clear()
                salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6))
                salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5))
                salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4))
                salties.add(Product("Philly cheese steak", R.drawable.phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6))
                salties.add(Product("Nachos", R.drawable.nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7))
                coldDrinks = salties
            }
        }

    }

    private class AdaptadorProductos: BaseAdapter {
    var productos = ArrayList<Product>();
        var context: Context? = null;

        constructor(context: Context, productos: ArrayList<Product>){
            this.context=context
            this.productos=productos
    }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador = LayoutInflater.from(context)
            var vista  = inflador.inflate(R.layout.productos_view, null)

            vista.producto_img.setImageResource(prod.image)
            vista.producto_nombre.setText(prod.name)
            vista.producto_des.setText(prod.description)
            vista.producto_precio.setText("$${prod.price}")

            return vista
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
        }

        override fun getCount(): Int {
            return productos.size
        }
    }
}