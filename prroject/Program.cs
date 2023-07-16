

using Assignment1CSharp.Controllers;
using Assignment1CSharp.Models;
using Assignment1CSharp.UnitOfWork;
using System.Collections.Generic;
using System;

class Program
{
    public static void Main(String[] args)
    {
        bool isRunning = true;
        IUnitOfWork unitOfWork = new UnitOfWork();
        CustomerController customerController = new CustomerController(unitOfWork);
        while (isRunning)
        {


            Console.WriteLine("\n ====== MENU ====== \n");
            Console.WriteLine("1. CRUD Product");
            Console.WriteLine("2. CRUD Customer");
            Console.WriteLine("3. CRUD Order");
            Console.WriteLine("4. CRUD Membership");
            Console.WriteLine("0. Exit");

            Console.Write("Enter Selection: ");
            int choice = Convert.ToInt32(Console.ReadLine());

            switch (choice)
            {
                case 1:

                    Console.WriteLine("\n ======= CRUD Product ======= \n");
                    Console.WriteLine("1. CreateNewProduct");
                    Console.WriteLine("2. ReadProduct ");
                    Console.WriteLine("3. UpdateProduct ");
                    Console.WriteLine("4. DeleteProduct ");
                    Console.WriteLine("0. Back ");

                    Console.Write("Enter Selection:");

                    ProductController productController = new ProductController(unitOfWork);

                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:

                            Console.Write("Enter Name:");
                            string name = Console.ReadLine();
                            Console.Write("Enter Price:");
                            double price = Convert.ToDouble(Console.ReadLine());
                            Product product = new Product
                            {
                                Name = name,
                                Price = price
                            };
                            productController.Add(product);

                            break;
                        case 2:
                            Console.WriteLine("\n <====== All Product ======> \n");
                            List<Product> productsList = productController.GetAll();
                            foreach (Product p in productsList)
                            {
                                Console.WriteLine($"{p.Id} {p.Name} {p.Price}");
                            }
                            break;

                        case 3:
                            Console.Write("Enter Id :");
                            int id = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter new name: ");
                            string newName = Console.ReadLine();
                            Console.Write("Enter new price: ");
                            double newPrice = Convert.ToDouble(Console.ReadLine());
                            Product newProduct = new Product
                            {
                                Id = id,
                                Name = newName,
                                Price = newPrice
                            };
                            productController.Update(id, newProduct);

                            break;

                        case 4:
                            Console.Write("Enter Id: ");
                            int DeleteId = Convert.ToInt32(Console.ReadLine());
                            productController.Delete(DeleteId);

                            break;

                        case 0:

                            break;
                        default:
                            Console.WriteLine("\n Invalid choice please choose again.");

                            break;
                    }
                    break;

                case 2:

                    Console.WriteLine("\n ======= CRUD Customer ======= \n");
                    Console.WriteLine("1. CreateNewCustomer");
                    Console.WriteLine("2. ReadCustomer ");
                    Console.WriteLine("3. UpdateCustomer ");
                    Console.WriteLine("4. DeleteCustomer ");
                    Console.WriteLine("0. Back ");

                    Console.Write("Enter Selection:");



                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:

                            Console.Write("Enter Name:");
                            string name = Console.ReadLine();
                            Console.Write("Enter Phone:");
                            string phone = Console.ReadLine();
                            Console.Write("Enter Email:");
                            string email = Console.ReadLine();
                            Console.Write("Enter membership ID: ");
                            int id = Convert.ToInt32(Console.ReadLine());
                            Customer customer = new Customer
                            {
                                Name = name,
                                Phone = phone,
                                Email = email,
                                MembershipId = id
                            };

                            customerController.Add(customer);

                            break;
                        case 2:

                            Console.WriteLine("\n <====== All Customer ======> \n");
                            List<Customer> customersList = customerController.GetAll();
                            foreach (Customer c in customersList)
                            {
                                Console.WriteLine($"{c.Id} {c.Name} {c.Phone} {c.Email}");
                            }
                            break;


                        case 3:
                            Console.Write("Enter Id :");
                            id = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter new name: ");
                            string newName = Console.ReadLine();
                            Console.Write("Enter new phone:");
                            string newPhone = Console.ReadLine();
                            Console.Write("Enter new email:");
                            string newEmail = Console.ReadLine();
                            Customer newCustomer = new Customer
                            {
                                Id = id,
                                Name = newName,
                                Phone = newPhone,
                                Email = newEmail
                            };
                            customerController.Update(id, newCustomer);

                            break;

                        case 4:
                            Console.Write("Enter Id: ");
                            int DeleteId = Convert.ToInt32(Console.ReadLine());
                            customerController.Delete(DeleteId);

                            break;

                        case 0:

                            break;
                        default:
                            Console.WriteLine("\n Invalid choice please choose again.");

                            break;
                    }
                    Console.ReadLine();
                    break;
                case 3:

                    Console.WriteLine("\n ======= CRUD Order ======= \n");
                    Console.WriteLine("1. CreateNewOrder");
                    Console.WriteLine("2. ReadOrder ");
                    Console.WriteLine("3. UpdateOrder");
                    Console.WriteLine("4. DeleteOrder");
                    Console.WriteLine("0. Back ");

                    Console.Write("Enter Selection:");

                    OrderController orderController = new OrderController(unitOfWork);

                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:

                            Console.Write("Enter Customer Id:");
                            int cusId = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter Total:");
                            string total = Console.ReadLine();
                            Order order = new Order
                            {
                                CustomerId = cusId,
                                Total = total

                            };


                            orderController.Add(order);

                            break;
                        case 2:
                            Console.WriteLine("\n <====== All Product ======> \n");
                            List<Order> orders = orderController.GetAll();
                            foreach (Order o in orders)
                            {

                                Console.WriteLine($"{o.Id} {o.Customer.Name} {o.Customer.Phone} {o.Total}");

                            }
                            break;

                        case 3:
                            Console.Write("Enter Id: ");
                            int id = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter new customer Id:");
                            int newCusId = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter Total:");
                            string newTotal = Console.ReadLine();
                            Order newOrder = new Order
                            {
                                Id = id,
                                CustomerId = newCusId,
                                Total = newTotal
                            };
                            orderController.Update(id, newOrder);

                            break;

                        case 4:
                            Console.Write("Enter Id: ");
                            int DeleteId = Convert.ToInt32(Console.ReadLine());
                            orderController.Delete(DeleteId);

                            break;

                        case 0:

                            break;
                        default:
                            Console.WriteLine("\n Invalid choice please choose again.");

                            break;
                    }

                    break;

                case 4:

                    Console.WriteLine("\n ======= CRUD Membership ======= \n");
                    Console.WriteLine("1. CreateNewMembership");
                    Console.WriteLine("2. ReadMembership ");
                    Console.WriteLine("3. UpdateMembership");
                    Console.WriteLine("4. DeleteMembership");
                    Console.WriteLine("0. Back ");

                    Console.Write("Enter Selection:");

                    MembershipController membershipController = new MembershipController(unitOfWork);

                    choice = Convert.ToInt32(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:

                            Console.Write("Enter Name:");
                            string name = Console.ReadLine();
                            Membership membership = new Membership
                            {
                                Name = name
                            };


                            membershipController.Add(membership);

                            break;
                        case 2:
                            Console.WriteLine("\n <====== All Product ======> \n");
                            List<Membership> memberships = membershipController.GetAll();
                            foreach (Membership m in memberships)
                            {
                                Console.WriteLine($"{m.Name}");
                            }
                            break;

                        case 3:
                            Console.Write("Enter Id:");
                            int id = Convert.ToInt32(Console.ReadLine());
                            Console.Write("Enter New Name:");
                            string newName = Console.ReadLine();
                            Membership newMembership = new Membership
                            {
                                Id = id,
                                Name = newName
                            };
                            membershipController.Update(id, newMembership);

                            break;

                        case 4:
                            Console.Write("Enter Id: ");
                            int DeleteId = Convert.ToInt32(Console.ReadLine());
                            membershipController.Delete(DeleteId);
                            Console.WriteLine("Delete Success");
                            break;

                        case 0:

                            break;
                        default:
                            Console.WriteLine("\n Invalid choice please choose again.");

                            break;
                    }

                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    Console.WriteLine("Invalid choice please choose again.");

                    break;
            }
        }
    }
}