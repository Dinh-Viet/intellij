using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamCSharp
{
    public class ProductManegement
    {
        private List<Product> products = new List<Product>();
        public void AddNewProduct()
        {
            
            Console.WriteLine("=========CREATE PRODUCT=========\n");
            try
            {
                
                Console.WriteLine("Enter product:");
                Console.WriteLine("Product ID: ");
                int productId = int.Parse(Console.ReadLine());

                Console.WriteLine("Enter Name: ");
                string name = Console.ReadLine();

                Console.WriteLine("Enter Price: ");
                decimal price = decimal.Parse(Console.ReadLine());
                Product newProduct = new Product(productId, name, price);
                AddProductToList(newProduct);
                Console.WriteLine("Product added success");
            }
            catch(FormatException)
            {
                throw new Exception("Invalid Price please enter an integer");
            }
            catch (OverflowException)
            {
                throw new Exception("Ineligible entry quantity");
            }
        }

        private void AddProductToList(Product newProduct)
        {
            products.Add(newProduct);
        }
        public void DisplayProducts()
        {

            Console.WriteLine("=========DISPLAY PRODUCT=========\n");
            if (products.Count == 0)
            {
                Console.WriteLine("No products found.");
            }
            else
            {
                Console.WriteLine("Product Records:");
                foreach (Product product in products)
                {
                    Console.WriteLine($"Product ID: {product.ProductId}, Name: {product.Name}, Price: {product.Price}");
                }
            }
        }

        public void DeleteNewProduct()
        {
            Console.WriteLine("=========DELETE PRODUCT=========\n");
            try
            {
                Console.Write("Enter Product ID to delete: ");
                int productId = int.Parse(Console.ReadLine());

                DeleteProductById(productId);
                Console.WriteLine("Product deleted success.");
            }
            catch (FormatException)
            {
                throw new Exception("Invalid ID please enter an integer.");
            }
            catch (OverflowException)
            {
                throw new Exception("The number entered is too large or too small.");
            }
        }

        private void DeleteProductById(int productId)
        {
            int index = products.FindIndex(p => p.ProductId == productId);

            if (index != -1)
            {
                products.RemoveAt(index);
            }
            else
            {
                throw new Exception("Product with the given ID not found.");
            }
        }
    }
}
