using ExamCSharp;

public class Program
{
    static void Main(string[] args)
    {

        ProductManegement productManegement = new ProductManegement();
        bool isRunning = true;

        while (isRunning)
        {

            
            Console.WriteLine("\n ====== MENU ====== \n");
            Console.WriteLine("1. Add Product");
            Console.WriteLine("2. Display Product");
            Console.WriteLine("3. Delete Product");
            Console.WriteLine("4. Exit");

            Console.Write("Enter Selection: ");
            int choice = Convert.ToInt32(Console.ReadLine());
            Console.Clear();
            switch (choice)
            {
                case 1:
                    Console.Clear();
                    productManegement.AddNewProduct();
                    break;
                case 2:
                    Console.Clear();
                    productManegement.DisplayProducts();
                    break;
                case 3:
                    Console.Clear();
                    productManegement.DeleteNewProduct();
                    break;

                case 4:
                    Environment.Exit(0);
                    isRunning = false;
                    break;

                default:
                    Console.WriteLine("Invalid choice please choose again.");

                    break;
            }
        }
    }
}

