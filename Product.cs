using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamCSharp
{
    public class Product
    {
        public int ProductId { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public Product(int productId, string name, decimal price)
        {
            ProductId = productId;
            Name = name;
            Price = price;
        }   
    }
}
